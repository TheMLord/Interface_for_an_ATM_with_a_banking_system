package com.example.ATMMachine.userAtm;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends AbstractUser {

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User() {

    }
}
