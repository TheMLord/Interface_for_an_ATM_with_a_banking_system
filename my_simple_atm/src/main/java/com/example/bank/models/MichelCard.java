package com.example.bank.models;

/**
 *
 * @author npyatak
 * @since 13.10.2022
 */
public class MichelCard extends AbstractCardDetails
{
    public MichelCard()
    {
        cardOwner = "Миша";
        id = 3L;
        cardNumber = 1111_1111_2222_1111L;
        cardCurrentBalance = 5050L;
    }
}
