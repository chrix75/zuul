package com.imscd.poc.access.domain;

/**
 * Created by csperandio on 15/07/2016.
 */
public class Account {
    private String login;
    private String password;
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean isCorrectPassword(String password) {
        return this.password.equals(password);
    }
}
