package com.example.kursinisdarbas.model;




public class Other extends Product {
    private int id;
    private double weight;

    public Other(String title, String description) {
        super(title, description);
    }

    public Other(String title, String description, String manufacturer) {
        super(title, description, manufacturer);
    }

    public Other(String title, String description, String manufacturer, Warehouse warehouse, ProductType productType) {
        super(title, description, manufacturer, warehouse, productType);
    }
}
