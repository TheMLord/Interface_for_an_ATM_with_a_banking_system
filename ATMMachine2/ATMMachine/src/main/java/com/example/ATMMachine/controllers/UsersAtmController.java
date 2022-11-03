package com.example.ATMMachine.controllers;

import com.example.ATMMachine.services.UserCastomService;
import com.example.ATMMachine.services.UserService;
import com.example.ATMMachine.userAtm.User;
import com.example.ATMMachine.userAtm.UserAtm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersAtmController {
    private final List<UserService> userAtmService;

    @Inject
    public UsersAtmController(List<UserService> userAtmService) {

        this.userAtmService = userAtmService;
    }

    @GetMapping(value = "/users")
    @ResponseBody
    public List<UserAtm> getAllUsersAtms(){

        List<UserAtm> users = new ArrayList<>();
        userAtmService.forEach(userService -> users.addAll(userService.getUsers()));
        return users;
    }

    @GetMapping(value ="/signin/{login}:{password}")
    @ResponseBody
    public List<UserAtm> saveUser(@PathVariable String login,@PathVariable String password){
        userAtmService.stream()
                .filter(userService -> userService instanceof UserCastomService)
                .findFirst()
                .get()
                .saveUser(login, password);
        return getAllUsersAtms();
    }

}
