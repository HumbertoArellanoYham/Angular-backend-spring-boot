package com.arellano.application.rest.springboot.springbootrest.services;

import java.util.List;
import java.util.Optional;

import com.arellano.application.rest.springboot.springbootrest.entities.Product;

public interface ProductService {

    List<Product> listAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    Optional<Product> delete(Product product);
}
