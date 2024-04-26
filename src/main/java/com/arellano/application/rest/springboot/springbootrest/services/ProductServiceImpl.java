package com.arellano.application.rest.springboot.springbootrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arellano.application.rest.springboot.springbootrest.entities.Product;
import com.arellano.application.rest.springboot.springbootrest.repositories.ProductRepository;

@Service
@Qualifier("productService")
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(@Qualifier("productRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> listAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> delete(Product product) {
        Optional<Product> productFindById = productRepository.findById(product.getIdproducto());

        productFindById.ifPresent((p) -> {
            productRepository.delete(p);
        });

        return productFindById;
    }

}
