package com.example.ATMDEMO.accounts;

public class Account {
    private Long id;

    public Account() {}

    public Account(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
