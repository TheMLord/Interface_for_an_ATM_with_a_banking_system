package com.example.ATMDEMO.services;

import com.example.ATMDEMO.accounts.Account;

import java.util.List;
import java.util.stream.Collectors;

abstract class AbstractAccountService implements AccountService {
    protected List<Account> accounts;

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public Account getAccountById(Long Id) {
        List<Account> found = accounts.stream().filter(magician -> magician.getId() == Id)
                .collect(Collectors.toList());
        return found.size() == 0 ? null : found.stream().findFirst().get();
    }
}
