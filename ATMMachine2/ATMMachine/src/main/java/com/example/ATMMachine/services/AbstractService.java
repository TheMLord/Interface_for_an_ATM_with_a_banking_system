package com.example.ATMMachine.services;

import com.example.ATMMachine.userAtm.UserAtm;

import java.util.List;

public class AbstractService implements UserService{
    protected List<UserAtm> userAtm;

    @Override
    public List<UserAtm> getUsers() {
        return userAtm;
    }

    @Override
    public void restoreAccount(String login) {

    }
}
