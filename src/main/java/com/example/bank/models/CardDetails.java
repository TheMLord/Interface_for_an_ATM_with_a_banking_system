package com.example.bank.models;

/**
 *
 * @author npyatak
 * @since 13.10.2022
 */
public interface CardDetails
{
    String getCardOwner();
    Long getId();
    Long getCardNumber();
    Long getCardCurrentBalance();
}
