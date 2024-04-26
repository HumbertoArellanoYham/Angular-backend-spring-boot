package com.arellano.application.rest.springboot.springbootrest.entities;

import java.util.ArrayList;
import java.util.List;

public class MultiplesProducts {
    List<Product> listProducts;

    public MultiplesProducts(){
        listProducts = new ArrayList<>();
    }

    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
    }

}
