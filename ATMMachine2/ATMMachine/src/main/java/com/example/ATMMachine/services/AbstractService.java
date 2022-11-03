package com.example.ATMMachine.services;

import com.example.ATMMachine.userAtm.UserAtm;

import java.util.List;
import java.util.stream.Collectors;

public class AbstractService implements UserService{
    protected List<UserAtm> userAtm;

    @Override
    public List<UserAtm> getUsers() {
        return userAtm;
    }

    @Override
    public void restoreAccount(String login) {

    }
    @Override
    public UserAtm getUserById(Long id)
    {
        List<UserAtm> found =
                userAtm.stream().filter(magician -> magician.getId() == id)
                        .collect(Collectors.toList());
        return found.size() == 0 ? null : found.stream().findFirst().get();
    }
    @Override
    public void saveUser(String login, String password)
    {

    }
}
