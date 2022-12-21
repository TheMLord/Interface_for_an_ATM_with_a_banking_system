package com.example.bank.controllers;

import com.example.bank.models.CardDetails;
import com.example.bank.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.inject.Inject;
import java.util.ArrayList;

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

    @GetMapping("")
    public String homePage(Model model) {
        model.addAttribute("message", "ID пользователя: " +
                getCurrentCardbNumberData().toArray()[0].toString());
        model.addAttribute("messageCardNumber", "Номер карты пользователя: " +
                getCurrentCardbNumberData().toArray()[1].toString());
        model.addAttribute("messageFirstName", "Имя пользователя: "
                + getCurrentCardbNumberData().toArray()[4].toString());
        model.addAttribute("messageBalance", "Баланс: "
                + getCurrentCardbNumberData().toArray()[6].toString());
        return "home";
    }

    public ArrayList<Object> getCurrentCardbNumberData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CardDetails obj = new CardDetails(userRepository, auth);
        return obj.GetData();
    }

    @PostMapping("/goAdd")
    public Object goAdd() {
        return "redirect:/add";
    }

    @PostMapping("/goSub")
    public Object goSub() {
        return "redirect:/sub";
    }

    @PostMapping("/goAddAnother")
    public Object goAddAnother() {
        return "redirect:/addAnotherUser";
    }



}