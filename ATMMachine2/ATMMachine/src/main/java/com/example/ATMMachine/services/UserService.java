package com.example.ATMMachine.services;

import com.example.ATMMachine.userAtm.UserAtm;

import java.util.List;

public interface UserService {
    List<UserAtm> getUsers();

    void restoreAccount(String login);

    UserAtm getUserById(Long id);

    void saveUser(String login, String password);

}
