package com.example.ATMDEMO.accounts;

public class Card extends Account {
    private Long number;
    private Long date;
    private Integer CVC;
    private Double balance;

    public Card(Long number, Long date, Integer CVC, Double balance) {
        this.number = number;
        this.date = date;
        this.CVC = CVC;
        this.balance = balance;
    }

    public Card(Long id, Long number, Long date, Integer CVC, Double balance) {
        super(id);
        this.number = number;
        this.date = date;
        this.CVC = CVC;
        this.balance = balance;
    }

    public Card() {}

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getCVC() {
        return CVC;
    }

    public void setCVC(Integer CVC) {
        this.CVC = CVC;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
