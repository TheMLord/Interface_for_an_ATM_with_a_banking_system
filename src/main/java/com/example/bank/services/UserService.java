package com.example.bank.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.example.bank.models.Money;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.bank.models.Role;
import com.example.bank.models.User;
import com.example.bank.repositories.UserRepository;

/**
 * Класс с сервисами для пользователя
 */
@Component
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByCardnumber(String cardnumber) throws UsernameNotFoundException {
        User myUser = userRepository.findByCardNumber(cardnumber);
        return new org.springframework.security.core.userdetails.User(myUser.getCardNumber(), myUser.getPIN(),
                mapRolesToAthorities(myUser.getRoles()));
    }

    public ArrayList<Object> loadDataByCardnumber(String cardnumber) throws UsernameNotFoundException {
        ArrayList<Object> data = new ArrayList<Object>();

        User myUser = userRepository.findByCardNumber(cardnumber);

        data.add(myUser.getId());
        data.add(myUser.getCardNumber());
        data.add(myUser.getCvv());
        data.add(myUser.getFirstName());
        data.add(myUser.getLastName());
        data.add(myUser.getBalance());

        return data;
    }


    private List<? extends GrantedAuthority> mapRolesToAthorities(Set<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.name())).collect(Collectors.toList());
    }

    public void addUser(User user) throws Exception {
        User userFromDb = userRepository.findByCardNumber(user.getCardNumber());
        if (userFromDb != null) {
            throw new Exception("user exist");
        }
        user.setRoles(Collections.singleton(Role.CLIENT));
        user.setActive(true);
        userRepository.save(user);
    }

    public void changeCashUser(User user, Long cash) {
        user.setBalance(cash);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadUserByCardnumber(username);
    }

    public void addMoney(Money money) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User myUser = userRepository.findByCardNumber(auth.getName());
        Long sum = money.add + myUser.getBalance();
        myUser.setBalance(sum);
        changeCashUser(myUser, sum);
        userRepository.save(myUser);
    }

    public Boolean subMoney(Money money) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User myUser = userRepository.findByCardNumber(auth.getName());
        Long sub = myUser.getBalance() - money.sub;

        if (sub > 0) {
            myUser.setBalance(sub);
            changeCashUser(myUser, sub);
            userRepository.save(myUser);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public String addMoneyAnotherUser(String cardNumber, Money money) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User myUser = userRepository.findByCardNumber(auth.getName());
        try {
            User anotherUser = userRepository.findByCardNumber(cardNumber);
            Long sub = myUser.getBalance() - money.add;

            if (sub > 0) {
                myUser.setBalance(sub);
                changeCashUser(myUser, sub);
                userRepository.save(myUser);

                Long sum = money.add + anotherUser.getBalance();
                anotherUser.setBalance(sum);
                changeCashUser(anotherUser, sum);
                userRepository.save(anotherUser);
                return "1";
            } else {
                return "2";
            }
        } catch (Exception e) {
            return "3";
        }

    }
}
