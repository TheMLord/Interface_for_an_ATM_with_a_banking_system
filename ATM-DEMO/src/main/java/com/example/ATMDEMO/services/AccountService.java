package com.example.ATMDEMO.services;

import com.example.ATMDEMO.accounts.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    Account getAccountById(Long Id);
}
