package com.example.ATMMachine.userAtm;

public class AbstractUser implements UserAtm{
    protected String login;
    protected String password;

    @Override
    public String getLogin() {
        return login;
    }
    @Override
    public String getpassword() {
        return password;
    }
}
