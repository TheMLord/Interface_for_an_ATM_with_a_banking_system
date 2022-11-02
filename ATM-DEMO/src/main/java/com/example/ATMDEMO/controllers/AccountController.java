package com.example.ATMDEMO.controllers;

import com.example.ATMDEMO.accounts.Account;
import com.example.ATMDEMO.services.AccountService;
import jdk.jfr.consumer.RecordedStackTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {
    private final List<AccountService> accountServices;

    @Autowired
    public AccountController(List<AccountService> accountServices) {
        this.accountServices = accountServices;
    }

    @GetMapping(value = "/cards")
    @ResponseBody
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accountServices.forEach(magicianService ->accounts.addAll(magicianService.getAccounts()));
        return accounts;
    }
}
