package com.example.bank.models;

/**
 * Класс для построения транзакции между пользователями
 */
public class Transaction {
    public String cardNumber;
    public Money money;

    public String getCardNumber() {
        return cardNumber;
    }

    public Money getMoneyTransaction() {
        return money;
    }

    public void setCardNumberTransaction(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
