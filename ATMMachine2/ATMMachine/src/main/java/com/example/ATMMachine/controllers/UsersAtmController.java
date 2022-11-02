package com.example.ATMMachine.controllers;

import com.example.ATMMachine.services.UserService;
import com.example.ATMMachine.userAtm.UserAtm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
public class UsersAtmController {
    private final UserService userAtmService;

    @Inject
    public UsersAtmController(UserService userAtmService) {

        this.userAtmService = userAtmService;
    }

    @GetMapping(value = "/atm")
    @ResponseBody
    public List<UserAtm> getAllUsersAtms(){

        return userAtmService.getUsers();
    }

}
