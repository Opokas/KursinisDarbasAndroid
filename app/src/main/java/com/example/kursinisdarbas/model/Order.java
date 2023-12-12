package com.example.kursinisdarbas.model;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Order extends Cart {
    int status;
    int manager;
    int orderID;

    public  Order(Customer customer,Product product,int orderID){
        super(customer,product);
        this.orderID=orderID;
    }




    @Override
    public String toString() {
        return "Order | "+orderID;
    }
    //
//      @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
//    //@LazyCollection(LazyCollectionOption.FALSE)
//    private List<Product> itemsInCart;
//    @OneToOne(optional = false)
//    private Customer customer;

}
