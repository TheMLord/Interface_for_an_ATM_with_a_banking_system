package com.example.ATMMachine.userAtm;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractUser implements UserAtm{
    protected String login;
    protected String password;
    @Id
    @GeneratedValue
    protected Long id;

    @Override
    public String getLogin() {
        return login;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public Long getId() {
        return id;
    }
}
