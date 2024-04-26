package com.arellano.application.rest.springboot.springbootrest.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.arellano.application.rest.springboot.springbootrest.entities.Sell;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
@Qualifier("sellRepository")
public interface SellRepository extends CrudRepository<Sell, Long>{

    @Query("SELECT s FROM Sell s WHERE s.fecha = ?1")
    Optional<Sell> obtenerVentaPorFecha(String fecha);

    @Modifying
    @Query("UPDATE Product p SET p.existencia = p.existencia - ?2 WHERE p.nombre = ?1")
    void modificarStock(String nombre, Integer cantidad);

}
