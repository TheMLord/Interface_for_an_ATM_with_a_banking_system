package com.example.bank.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.bank.models.CardDetails;

/**
 *
 * @author npyatak
 * @since 13.10.2022
 */
public class AbstractCardService implements CardService
{
    protected List<CardDetails> cards;

    @Override
    public List<CardDetails> getCards()
    {
        return cards;
    }

    //TODO 3 добавить getCardByCardName
    @Override
    public CardDetails getCardById(Long id)
    {
        List<CardDetails> found =
                cards.stream().filter(card -> card.getId() == id)
                        .collect(Collectors.toList());
        return found.size() == 0 ? null : found.stream().findFirst().get();
    }

    @Override
    public void SaveCard(String name)
    {

    }
}
