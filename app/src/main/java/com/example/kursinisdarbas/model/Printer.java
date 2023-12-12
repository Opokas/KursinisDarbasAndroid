package com.example.kursinisdarbas.model;




public class Printer extends Product {
    private double xSize;
    private double ySize;
    private double zSize;
    private double nozzleSize;
    private double weight;
    public Printer(String title, String description, double xSize,double ySize,double zSize,double nozzleSize,double weight) {
        super(title, description);
        this.xSize = xSize;
        this.ySize=ySize;
        this.zSize=zSize;
        this.nozzleSize=nozzleSize;
        this.weight=weight;
    }
    public Printer(String title, String description, String manufacturer, Warehouse warehouse,ProductType productType,double xSize,double ySize,double zSize,double nozzleSize,double weight) {
        super(title, description, manufacturer, warehouse,productType);
        this.xSize = xSize;
        this.ySize=ySize;
        this.zSize=zSize;
        this.nozzleSize=nozzleSize;
        this.weight=weight;
    }


}

/*

public class Plant extends Product {

    private LocalDate plantDate;

    public Plant(String title, String description, LocalDate plantDate) {
        super(title, description);
        this.plantDate = plantDate;
    }

    public Plant(String title, String description, String manufacturer, Warehouse warehouse, LocalDate plantDate) {
        super(title, description, manufacturer, warehouse);
        this.plantDate = plantDate;
    }
}
*/