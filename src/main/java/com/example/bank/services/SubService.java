package com.example.bank.services;

import com.example.bank.models.Money;
import com.example.bank.models.User;
import com.example.bank.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.inject.Inject;

public class SubService {
    private final UserRepository userRepository;
    private final UserService userService;

    @Inject
    public SubService(UserRepository userRepository, UserService userService)
    {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public void subMoney(Money money){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User myUser = userRepository.findByCardnumber(auth.getName());
        Long sum = myUser.getBalance() - money.sub;
        myUser.setBalance(sum);
        userService.changeCashUser(myUser, sum);
        userRepository.save(myUser);
    }
}
