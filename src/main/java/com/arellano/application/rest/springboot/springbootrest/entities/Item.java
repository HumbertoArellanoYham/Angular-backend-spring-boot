package com.arellano.application.rest.springboot.springbootrest.entities;

import java.io.Serializable;

public class Item implements Serializable{
    private Product product; 
    private int quantity;

    public Item(){}

    public Item(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getImporte(){
        return product.getPrecio() * quantity;
    }
}
