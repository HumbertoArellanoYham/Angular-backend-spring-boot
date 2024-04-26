package com.arellano.application.rest.springboot.springbootrest.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdenVenta {
    @Autowired
    private Sell sell;

    List<Item> items;

    public OrdenVenta() {
        items = new ArrayList<Item>();
    }

    public Sell getSell() {
        return sell;
    }

    public void setSell(Sell sell) {
        this.sell = sell;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getTotal() {
        return items.stream().mapToInt(Item::getImporte).sum();
    }

}
