package com.example.bank.controllers;

import com.example.bank.models.Money;
import com.example.bank.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.inject.Inject;

/**
 * Класс-контроллер операции снятия наличных
 */
@Controller
public class SubMoneyController {
    private final UserService userService;

    @Inject
    public SubMoneyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sub")
    public String sub() {
        return "sub";
    }

    @PostMapping("/sub")
    public Object subMoney(Money money, Model model) {
        if (userService.subMoney(money)) {
            model.addAttribute("message", "Снято: " + money.getSub().toString());
        } else {
            model.addAttribute("message", "Недостаточно средств для совершения операции");
        }
        return "sub";
    }
}
