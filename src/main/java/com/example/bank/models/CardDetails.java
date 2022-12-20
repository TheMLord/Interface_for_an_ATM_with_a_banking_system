package com.example.bank.models;

import com.example.bank.repositories.UserRepository;
import org.springframework.security.core.Authentication;;
import java.util.ArrayList;

/**
 * Класс для получения данных пользователя
 */
public class CardDetails {
    ArrayList<Object> data = new ArrayList<>();

    public CardDetails(UserRepository userRepository, Authentication auth) {
        String cardNumber = auth.getName();

        User myUser = userRepository.findByCardNumber(cardNumber);

        this.data.add(myUser.getId());
        this.data.add(myUser.getCardNumber());
        this.data.add(myUser.getPIN());
        this.data.add(myUser.getCvv());
        this.data.add(myUser.getFirstName());
        this.data.add(myUser.getLastName());
        this.data.add(myUser.getBalance());
    }

    public ArrayList<Object> GetData() {
        return data;
    }
}
