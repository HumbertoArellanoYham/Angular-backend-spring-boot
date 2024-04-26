package com.arellano.application.rest.springboot.springbootrest.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arellano.application.rest.springboot.springbootrest.entities.OrdenVenta;
import com.arellano.application.rest.springboot.springbootrest.entities.Sell;
import com.arellano.application.rest.springboot.springbootrest.services.SellService;

@RestController
@RequestMapping("/api/sell")
public class SellController {

    private SellService sellService;

    public SellController(@Qualifier("sellService") SellService sellService) {
        this.sellService = sellService;
    }

    @GetMapping("/ventas")
    public ResponseEntity<?> listarVentas(){
        return ResponseEntity.ok(sellService.listAll());
    }

    @PostMapping
    public ResponseEntity<?> crearOrdenDeVenta(@RequestBody OrdenVenta ordenVenta){
        Map<String, Integer> hashItems = new HashMap<String, Integer>();

        ordenVenta.getItems().forEach((item) -> {
            hashItems.put(item.getProduct().getNombre(), item.getQuantity());
        });

        for(Map.Entry<String, Integer> entry : hashItems.entrySet()){
            String nombre = entry.getKey();
            Integer cantidadComprar = entry.getValue();

            sellService.modificarStock(nombre, cantidadComprar);
        }


        Sell newSell = ordenVenta.getSell();
        
        return ResponseEntity.status(HttpStatus.CREATED).body(sellService.guardarVenta(newSell));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarVenta(@PathVariable Long id, @RequestBody Sell sell){
        sell.setIdVentas(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(sellService.guardarVenta(sell));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVenta(@PathVariable Long id){
        Optional<Sell> sellFound = sellService.findById(id);

        if(sellFound.isPresent()){
            return ResponseEntity.ok(sellService.delete(sellFound.orElseThrow()));
        }

        return ResponseEntity.notFound().build();
    }
}
