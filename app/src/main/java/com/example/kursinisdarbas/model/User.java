package com.example.kursinisdarbas.model;


import java.io.Serializable;
import java.time.LocalDate;



public class User implements Serializable {

    int id;

    String login;
    String password;
    //LocalDate birthDate;
    String name;
    String surname;
    String address;
    String cardno;
    public User(){}
    public User(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
//        this.birthDate = birthDate;
        this.name = name;
        this.surname = surname;
    }

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
//        this.birthDate = birthDate;

    }
    public User(int id, String login, String password,String name,String surname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.surname = surname;
        this.name = name;

    }


    public User(int id, String login, String password,String name,String surname,String address,String cardno) {
        this.id = id;
        this.login = login;
        this.password = password;
//        this.birthDate = birthDate;
        this.name=name;
        this.surname=surname;
        this.address=address;
        this.cardno=cardno;

    }


    @Override
    public String toString() {
        return this.id+"|"+this.name+" "+this.surname;
    }

    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }
    public boolean isCustomer(){
        if(this.cardno!=null||this.address!=null){
            return true;
        }else{
            return false;
        }
    }
}
