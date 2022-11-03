package com.example.ATMMachine.services;

import com.example.ATMMachine.repositories.UserRepository;
import com.example.ATMMachine.userAtm.User;
import com.example.ATMMachine.userAtm.UserAtm;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserCastomService extends AbstractService{
    private final UserRepository userRepository;

    @Inject
    public UserCastomService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserAtm> getUsers() {
        List<UserAtm> result = new ArrayList<>();
        userRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public UserAtm getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void saveUser(String login, String password) {
        User user = new User(login, password);
        userRepository.save(user);
    }
}
