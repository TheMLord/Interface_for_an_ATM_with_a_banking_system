package com.example.bank.models;

import com.example.bank.repositories.UserRepository;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;

public class CardDeteils {
    ArrayList<Object> data = new ArrayList<Object>();

    public CardDeteils(UserRepository userRepository, Authentication auth) {
        String cardnumber = auth.getName();

        User myUser = userRepository.findByCardnumber(cardnumber);

        this.data.add(myUser.getId());
        this.data.add(myUser.getCardnumber());
        this.data.add(myUser.getPIN());
        this.data.add(myUser.getCvv());
        this.data.add(myUser.getFirstName());
        this.data.add(myUser.getLastName());
        this.data.add(myUser.getBalance());
    }


    public ArrayList<Object> GetData() {
        return data;
    }

//    public User getUserByUsername(String username) {
//        CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
//        Root<User> userRequest = criteriaQuery.from(User.class);
//
//        Expression<String> exp = userRequest.get("username");
//        Predicate predicate = exp.in(username);
//
//        criteriaQuery.where(predicate);
//        try {
//            return em.createQuery(criteriaQuery).getSingleResult();
//        } catch (NoResultException e) {
//            return new User();
//        }
//    }
}
