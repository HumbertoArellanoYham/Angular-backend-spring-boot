package com.arellano.application.rest.springboot.springbootrest.services;

import java.util.List;
import java.util.Optional;

import com.arellano.application.rest.springboot.springbootrest.entities.Sell;

public interface SellService {

    List<Sell> listAll();

    Optional<Sell> obtenerVentaPorFecha(String fecha);

    Sell guardarVenta(Sell sell);

    Optional<Sell> delete(Sell sell);

    void modificarStock(String nombre, Integer cantidad);

    Optional<Sell> findById(Long id);
}
