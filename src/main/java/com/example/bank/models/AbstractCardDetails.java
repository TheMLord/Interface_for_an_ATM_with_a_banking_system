package com.example.bank.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author npyatak
 * @since 13.10.2022
 */
@MappedSuperclass
public class AbstractCardDetails implements CardDetails
{
    //TODO 1 создать поле с номером счета (id клиента в банке)
    //TODO 4 переименовать cardOwner в cardHolder
    protected String cardOwner;
    protected Long cardNumber;
    protected Long cardCurrentBalance;
    @Id
    @GeneratedValue
    protected Long id;

    public String getCardOwner()
    {
        return cardOwner;
    }

    @Override
    public Long getId()
    {
        return id;
    }

    @Override
    public Long getCardNumber() {
        return cardNumber;
    }

    @Override
    public Long getCardCurrentBalance() {
        return cardCurrentBalance;
    }
}
