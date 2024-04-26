package com.arellano.application.rest.springboot.springbootrest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Consumer;
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

import com.arellano.application.rest.springboot.springbootrest.entities.MultiplesProducts;
import com.arellano.application.rest.springboot.springbootrest.entities.Product;
import com.arellano.application.rest.springboot.springbootrest.services.ProductService;


@RestController
@RequestMapping("/api/products")
public class HomeController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @GetMapping("/")
    public List<Product> list() {
        return productService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Product> productFound = productService.findById(id);

        if(productFound.isPresent()){
            return ResponseEntity.ok(productFound.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }
    

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody MultiplesProducts multiplesProducts){
        multiplesProducts.getListProducts().forEach((product) -> {
            productService.save(product);
        });
        return null;
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> create(@PathVariable Long id, @RequestBody Product product){
        product.setIdproducto(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Product> productFound = productService.findById(id);

        if(productFound.isPresent()){
            return ResponseEntity.ok(productService.delete(productFound.orElseThrow()));
        }

        return ResponseEntity.notFound().build();
    }
}
