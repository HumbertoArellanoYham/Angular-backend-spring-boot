package com.arellano.application.rest.springboot.springbootrest.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.arellano.application.rest.springboot.springbootrest.entities.Product;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
@Qualifier("productRepository")
public interface ProductRepository extends CrudRepository<Product, Long>{

}
