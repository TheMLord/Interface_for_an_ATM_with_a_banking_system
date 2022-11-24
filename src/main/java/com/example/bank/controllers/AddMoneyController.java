package com.example.bank.controllers;

import javax.inject.Inject;

import com.example.bank.models.CardDeteils;
import com.example.bank.models.Money;
import com.example.bank.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bank.models.User;
import com.example.bank.services.UserService;

/**
 *
 * @author npyatak
 * @since 17.10.2022
 */
@Controller
public class AddMoneyController {

    private final UserRepository userRepository;

    @Inject
    public AddMoneyController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @GetMapping("/add")
    public String add()
    {
        return "add";
    }

    @PostMapping("/add")
    public Object addMoney(Money money, Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        CardDeteils obj = new CardDeteils(userRepository, auth);
        return model.getAttribute("add");

    }


}
