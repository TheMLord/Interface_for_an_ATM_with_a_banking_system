package com.example.bank.services;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import com.example.bank.models.DmitriyFirstCard;
import org.springframework.stereotype.Component;

import com.example.bank.models.DmitriySecondCard;

/**
 *
 * @author npyatak
 * @since 13.10.2022
 */
@Component
public class DmitiryCardService extends AbstractCardService
{

    public DmitiryCardService()
    {
        cards = new ArrayList<>();
        cards.add(new DmitriyFirstCard());
        cards.add(new DmitriySecondCard());
    }

    @PostConstruct
    public void init()
    {

    }

}
