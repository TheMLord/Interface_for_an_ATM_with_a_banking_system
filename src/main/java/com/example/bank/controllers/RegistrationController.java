package com.example.bank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.bank.models.User;
import com.example.bank.services.UserService;

import javax.inject.Inject;

/**
 * Класс-контроллер регистрации
 * Принимает номер карты и PIN-код и создает нового пользователя
 */
@Controller
public class RegistrationController {
    private final UserService userService;

    @Inject
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addNewUser(User user, Model model) {
        try {
            user.setBalance(0L);
            userService.addUser(user);
            return "redirect:/login";
        } catch (Exception ex) {
            model.addAttribute("message", "User exists");
            return "registration";
        }
    }
}
