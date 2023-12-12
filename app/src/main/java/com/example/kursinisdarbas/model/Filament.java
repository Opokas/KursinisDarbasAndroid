package com.example.kursinisdarbas.model;



public class Filament extends Product {
    private double weight;
    FilamentType filamentType;
    ColorType colorType;


    /*public Filament(String title, String description, double xSize,double ySize,double zSize,double nozzleSize,double weight) {
        super(title, description);
        this.filamentType=filamentType;
        this.colorType=colorType;
        this.weight=weight;
        this.weight=weight;
    }*/
    public Filament(String title, String description, String manufacturer, Warehouse warehouse,ProductType productType,FilamentType filamentType,ColorType colorType,double weight) {
        super(title, description, manufacturer, warehouse,productType);
        this.filamentType=filamentType;
        this.colorType=colorType;
        this.weight=weight;
    }

}
