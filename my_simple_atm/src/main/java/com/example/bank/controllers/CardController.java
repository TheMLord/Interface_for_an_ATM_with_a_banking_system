package com.example.bank.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bank.models.CardDetails;
import com.example.bank.services.DmitiryCardService;
import com.example.bank.services.CardService;
import com.example.bank.services.OtherCardService;
import com.example.bank.services.UserCardService;

/**
 *
 * @author npyatak
 * @since 13.10.2022
 */
@Controller
public class CardController
{
    @Value("${curentLoggedUser}")
    private String currentLoggedUser;
    private final List<CardService> cardServices;

    @Inject
    public CardController(List<CardService> cardService)
    {
        this.cardServices = cardService;
    }

    @GetMapping(value = "/allcards")
    @ResponseBody
    public List<CardDetails> getAllMagicians()
    {
        if (currentLoggedUser.equals("1"))
        {
            return cardServices.stream().
                    filter(cardService -> cardService instanceof DmitiryCardService)
                    .findFirst().get().getCards();
        }
        else if (currentLoggedUser.equals("2"))
        {
            return cardServices.stream().
                    filter(cardService -> (cardService instanceof OtherCardService))
                    .findFirst().get().getCards();
        }
        else
        {
            List<CardDetails> magicians = new ArrayList<>();
            cardServices.forEach(cardService ->magicians.addAll(cardService.getCards()));
            return magicians;
        }
    }

    @GetMapping(value ="/create/{name}")
    @ResponseBody
    public List<CardDetails> saveMagician(@PathVariable String name)
    {
        cardServices.stream()
                .filter(cardService -> cardService instanceof UserCardService)
                .findFirst()
                .get().
                SaveCard(name);
        return getAllMagicians();
    }
}
