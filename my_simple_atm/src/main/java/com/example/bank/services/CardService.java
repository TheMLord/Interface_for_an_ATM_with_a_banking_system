package com.example.bank.services;

import java.util.List;

import com.example.bank.models.CardDetails;

/**
 *
 * @author npyatak
 * @since 13.10.2022
 */
public interface CardService
{
    List<CardDetails> getCards();

    CardDetails getCardById(Long id);

    void SaveCard(String name);
}
