package com.example.kursinisdarbas.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Warehouse implements Serializable {

    private int id;
    private String title;
    private String address;




    public Warehouse(String title, String address) {
        this.title = title;
        this.address = address;
    }

    @Override
    public String toString() {
        return title;
    }


}
