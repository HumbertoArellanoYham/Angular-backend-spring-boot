package com.arellano.application.rest.springboot.springbootrest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.arellano.application.rest.springboot.springbootrest.entities.Product;

@CrossOrigin(origins = "http://localhost:4200")
public interface ProductRepository extends CrudRepository<Product, Long>{

}
