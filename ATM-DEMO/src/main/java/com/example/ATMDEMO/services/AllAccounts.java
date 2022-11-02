package com.example.ATMDEMO.services;

import com.example.ATMDEMO.test.models.Card1;
import com.example.ATMDEMO.test.models.Card2;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class AllAccounts extends AbstractAccountService {
    public AllAccounts() {
        accounts = new ArrayList<>();
        accounts.add(new Card1());
        accounts.add(new Card2());
    }
}
