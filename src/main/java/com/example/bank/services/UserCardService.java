package com.example.bank.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.example.bank.models.CardDetails;
import com.example.bank.models.UserCastomCard;
import com.example.bank.repositories.CardRepository;

/**
 *
 * @author npyatak
 * @since 13.10.2022
 */
@Component
public class UserCardService extends AbstractCardService
{
    private final CardRepository cardRepository;

    @Inject
    public UserCardService(CardRepository cardRepository)
    {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<CardDetails> getCards()
    {
        List<CardDetails> result = new ArrayList<>();
        cardRepository.findAll().forEach(result::add);
        return result;
    }
    @Override
    public CardDetails getCardById(Long id)
    {
        return cardRepository.findById(id).get();
    }
    @Override
    //TODO создание карты должно включать в себя еще и другие поля
    public void SaveCard(String name)
    {
        UserCastomCard card = new UserCastomCard(name);
        cardRepository.save(card);
    }
}
