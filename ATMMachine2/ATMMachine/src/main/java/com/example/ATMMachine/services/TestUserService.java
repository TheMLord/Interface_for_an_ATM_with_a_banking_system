package com.example.ATMMachine.services;

import com.example.ATMMachine.userAtm.TestUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TestUserService extends AbstractService{

    public TestUserService(){
        userAtm = new ArrayList<>();
        userAtm.add(new TestUser());
    }

}
