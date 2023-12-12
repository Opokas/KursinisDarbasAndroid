package com.example.kursinisdarbas.model;


import java.io.Serializable;
import java.time.LocalDate;



public abstract class User implements Serializable {

    int id;

    String login;
    String password;
    LocalDate birthDate;
    String name;
    String surname;

    public User(String login, String password, LocalDate birthDate, String name, String surname) {
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.name = name;
        this.surname = surname;
    }

    public User(int id, String login, String password, LocalDate birthDate) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return this.id+"|"+this.name+" "+this.surname;
    }
}
