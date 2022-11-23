package com.example.bank.models;

import javax.persistence.Entity;

/**
 *
 * @author npyatak
 * @since 13.10.2022
 */
@Entity
public class UserCastomCard extends AbstractCardDetails
{

    public UserCastomCard(String name)
    {
        this.cardOwner = name;
        this.cardCurrentBalance = 0L;
    }

    public UserCastomCard()
    {

    }
}
