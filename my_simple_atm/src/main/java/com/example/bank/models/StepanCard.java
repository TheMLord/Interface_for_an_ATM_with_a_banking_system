package com.example.bank.models;

/**
 *
 * @author npyatak
 * @since 13.10.2022
 */
public class StepanCard extends AbstractCardDetails
{
    public StepanCard()
    {
        cardOwner = "Степан";
        id = 2L;
        cardNumber = 1111_4444_2222_3333L;
        cardCurrentBalance = 8900L;
    }
}
