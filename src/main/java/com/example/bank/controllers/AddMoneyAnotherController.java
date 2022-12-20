package com.example.bank.controllers;

import com.example.bank.models.Money;
import com.example.bank.models.Transaction;
import com.example.bank.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.inject.Inject;

/**
 * Класс-контроллер операции перевода другому пользователю
 */
@Controller
public class AddMoneyAnotherController {
    private final UserService userService;
    private final Transaction transaction;

    @Inject
    public AddMoneyAnotherController(UserService userService) {
        this.userService = userService;
        this.transaction = new Transaction();
    }

    @GetMapping("/addAnotherUser")
    public String addAnotherUser() {
        return "addAnotherUser";
    }

    @GetMapping("/addAnotherCash")
    public String addAnotherCash() {
        return "addAnotherCash";
    }

    @PostMapping("/addAnotherUser")
    public Object addMoneyAnotherUser(String cardNumber, Model model) {
        this.transaction.setCardNumberTransaction(cardNumber);
        return "redirect:/addAnotherCash";
    }

    @PostMapping("/addAnotherCash")
    public Object addMoneyAnotherCash(Money money, Model model) {
        switch (userService.addMoneyAnotherUser(transaction.cardNumber, money)) {
            case "1":
                model.addAttribute("message", "Отправлено: " + money.getAdd().toString());
                model.addAttribute("message2", "Пользователю: " + transaction.cardNumber);
                break;
            case "2":
                model.addAttribute("message", "Недостаточно средств для совершения операции");
                break;
            case "3":
                model.addAttribute("message", "Неверно указан номер карты пользователя");
                break;
        }
        return "addAnotherCash";
    }

    @PostMapping("/goHomePageFromAddAnother")
    public Object goHomePageFromAddAnother() {
        return "redirect:";
    }
}
