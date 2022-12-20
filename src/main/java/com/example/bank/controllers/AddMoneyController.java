package com.example.bank.controllers;

import com.example.bank.models.Money;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.bank.services.UserService;

import javax.inject.Inject;

/**
 * Класс-контроллер операции зачисления денег на счет пользователя
 */
@Controller
public class AddMoneyController {
    private final UserService userService;

    @Inject
    public AddMoneyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public Object addMoney(Money money, Model model) {

        model.addAttribute("message", "Внесено: " + money.getAdd().toString());
        userService.addMoney(money);
        return "add";
    }

    @PostMapping("/goHomePageFromAdd")
    public Object goHomePageFromAdd() {
        return "redirect:";
    }
}