package com.example.kursinisdarbas.model;



import java.time.LocalDate;



public class Customer extends User {
    private String address;
    private String cardNo;

    public Customer(String login, String password, LocalDate birthDate, String name, String surname, String address, String cardNo) {
        super(login, password, birthDate, name, surname);
        this.address = address;
        this.cardNo = cardNo;
    }


}
