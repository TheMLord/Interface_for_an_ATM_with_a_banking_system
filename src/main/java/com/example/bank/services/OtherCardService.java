package com.example.bank.services;

import java.util.ArrayList;

import com.example.bank.models.MichelCard;
import org.springframework.stereotype.Component;

import com.example.bank.models.DmitriyFirstCard;
import com.example.bank.models.StepanCard;

/**
 *
 * @author npyatak
 * @since 13.10.2022
 */
@Component
public class OtherCardService extends AbstractCardService
{
    public OtherCardService()
    {
        cards = new ArrayList<>();
        cards.add(new MichelCard());
        cards.add(new StepanCard());
    }

}
