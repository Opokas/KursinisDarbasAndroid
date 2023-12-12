package com.example.kursinisdarbas.model;

import android.os.Build;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Cart {

    private int id;
    private LocalDate dateCreated;


public  Cart(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        this.dateCreated=LocalDate.now();
    }
}

    public Cart(Customer customer, Product product) {
    }

    /*
      @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    //@LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> itemsInCart;
    @OneToOne(optional = false)
    private Customer customer;


     */




}
