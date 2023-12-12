package com.example.kursinisdarbas.model;



import java.io.Serializable;


public class Product implements Serializable {

    String title;
    String description;
    String manufacturer;
    ProductType productType;


    public Product(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Product(String title, String description, String manufacturer) {
        this.title = title;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Product(String title, String description, String manufacturer, Warehouse warehouse,ProductType productType) {
        this.title = title;
        this.description = description;
        this.manufacturer = manufacturer;
        this.productType =productType;
    }
   @Override
    public String toString() {
        return title;
    }


}
