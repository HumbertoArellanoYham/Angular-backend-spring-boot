package com.arellano.application.rest.springboot.springbootrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable("listAll")
    public List<Product> listAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "Product", key = "#id")
    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productRepository.findById(id).get());
    }

    @Transactional
    @CachePut(cacheNames = "product")
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @CacheEvict(cacheNames = "product", beforeInvocation = false)
    @Override
    public Optional<Product> delete(Product product) {
        Optional<Product> productFindById = productRepository.findById(product.getIdproducto());

        productFindById.ifPresent((p) -> {
            productRepository.delete(p);
        });

        return productFindById;
    }

}
