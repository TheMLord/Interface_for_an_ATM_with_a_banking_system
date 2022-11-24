package com.example.bank.services;

import com.example.bank.models.CardDeteils;
import com.example.bank.models.Money;
import com.example.bank.models.User;
import com.example.bank.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.inject.Inject;

public class AddService {
    private final UserRepository userRepository;

    @Inject
    public AddService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void addMoney(Money money){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User myUser = userRepository.findByCardnumber(auth.getName());
        Long sum = money.add + myUser.getBalance();
        myUser.setBalance(sum);
    }
}
