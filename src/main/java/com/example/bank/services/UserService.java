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
 *
 * @author npyatak
 * @since 17.10.2022
 */
@Component
public class UserService implements UserDetailsService
{
    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByCardnumber(String cardnumber) throws UsernameNotFoundException
    {
        User myUser = userRepository.findByCardnumber(cardnumber);
        return new org.springframework.security.core.userdetails.User(myUser.getCardnumber(), myUser.getPIN(),
                mapRolesToAthorities(myUser.getRoles()));
    }

    public ArrayList<Object> loadDataByCardnumber(String cardnumber) throws UsernameNotFoundException
    {
        ArrayList<Object> data = new ArrayList<Object>();

        User myUser = userRepository.findByCardnumber(cardnumber);

        data.add(myUser.getId());
        data.add(myUser.getCardnumber());
        data.add(myUser.getCvv());
        data.add(myUser.getFirstName());
        data.add(myUser.getLastName());
        data.add(myUser.getBalance());

        return data;
    }


    private List<? extends GrantedAuthority> mapRolesToAthorities(Set<Role> roles)
    {
        return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.name())).collect(Collectors.toList());
    }

    public void addUser(User user) throws Exception
    {
        User userFromDb = userRepository.findByCardnumber(user.getCardnumber());
        if (userFromDb != null)
        {
            throw new Exception("user exist");
        }
        user.setRoles(Collections.singleton(Role.CLIENT));
        user.setActive(true);
        userRepository.save(user);
    }
    public void changeCashUser(User user, Long cash){
        user.setBalance(cash);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadUserByCardnumber(username);
    }

    public void addMoney(Money money){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User myUser = userRepository.findByCardnumber(auth.getName());
        Long sum = money.add + myUser.getBalance();
        myUser.setBalance(sum);
        changeCashUser(myUser, sum);
        userRepository.save(myUser);
    }
    public void subMoney(Money money){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User myUser = userRepository.findByCardnumber(auth.getName());
        Long sub =myUser.getBalance() - money.sub;
        myUser.setBalance(sub);
        changeCashUser(myUser, sub);
        userRepository.save(myUser);
    }
}
