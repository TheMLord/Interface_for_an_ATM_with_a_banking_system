package com.example.bank.controllers;

import com.example.bank.models.CardDeteils;
import com.example.bank.repositories.UserRepository;
import com.example.bank.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.ArrayList;

@Controller
public class HomepageController {

    private final UserRepository userRepository;

    @Inject
    public HomepageController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/home")
    @ResponseBody
    public Object getCurrentCardnumber() {

        return getCurrentCardbumberData();
    }

    public String getCurrentCardbumber() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public Object getCurrentCardbumberData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CardDeteils obj = new CardDeteils(userRepository, auth);
        return obj.GetData();
    }

}

//@Controller
//public class CardController
//{
//    @Value("${curentLoggedUser}")
//    private String currentLoggedUser;
//    private final List<CardService> cardServices;
//
//    @Inject
//    public CardController(List<CardService> cardService)
//    {
//        this.cardServices = cardService;
//    }
//
//    @GetMapping(value = "/allcards")
//    @ResponseBody
//    public List<CardDetails> getAllMagicians()
//    {
//        if (currentLoggedUser.equals("1"))
//        {
//            return cardServices.stream().
//                    filter(cardService -> cardService instanceof DmitiryCardService)
//                    .findFirst().get().getCards();
//        }
//        else if (currentLoggedUser.equals("2"))
//        {
//            return cardServices.stream().
//                    filter(cardService -> (cardService instanceof OtherCardService))
//                    .findFirst().get().getCards();
//        }
//        else
//        {
//            List<CardDetails> magicians = new ArrayList<>();
//            cardServices.forEach(cardService ->magicians.addAll(cardService.getCards()));
//            return magicians;
//        }
//    }
//
//    @GetMapping(value ="/create/{name}")
//    @ResponseBody
//    public List<CardDetails> saveMagician(@PathVariable String name)
//    {
//        cardServices.stream()
//                .filter(cardService -> cardService instanceof UserCardService)
//                .findFirst()
//                .get().
//                SaveCard(name);
//        return getAllMagicians();
//    }
//}