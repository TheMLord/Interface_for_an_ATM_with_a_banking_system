package com.example.bank.controllers;

import javax.inject.Inject;

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
public class RegistrationController
{

    private final UserService userService;

    @Inject
    public RegistrationController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String adduser(User user, Model model)
    {
        try
        {
            userService.addUser(user);
            return "redirect:/login";
        }
        catch (Exception ex)
        {
            model.addAttribute("message", "User exists");
            return "registration";
        }
    }
}
