package com.example.coursework6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.swing.*;

@Entity
@Getter
@Setter
public class Users extends IdField {
    private String login;
    private String password;
    private String role;
    private String secretCode;

    public Users(){ }

    public Users(Users users) {
        this.setId(users.getId());
        this.login = users.getLogin();
        this.password = users.getPassword();
        this.role = users.getRole();
        this.secretCode = users.getSecretCode();
    }
    public Users(String login, String password, String role, String secretCode){
        this.login = login;
        this.password = password;
        this.role = role;
        this.secretCode = secretCode;
    }
}


