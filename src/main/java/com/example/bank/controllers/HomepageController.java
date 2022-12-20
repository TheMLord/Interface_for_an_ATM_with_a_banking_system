package com.example.bank.controllers;

import com.example.bank.models.CardDetails;
import com.example.bank.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Класс-контроллер домашней страници пользователя
 * Выводит данные пользователя на экран
 */
@Controller
public class HomepageController {

    private final UserRepository userRepository;

    @Inject
    public HomepageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/home")
    @ResponseBody
    public Object getCurrentCardnumber() {

        return getCurrentCardbumberData();
    }

    public Object getCurrentCardbumberData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CardDetails obj = new CardDetails(userRepository, auth);
        return obj.GetData();
    }

}