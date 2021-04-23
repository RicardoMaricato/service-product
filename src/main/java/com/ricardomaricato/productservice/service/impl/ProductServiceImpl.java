package com.ricardomaricato.productservice.service.impl;

import com.ricardomaricato.productservice.model.Product;
import com.ricardomaricato.productservice.repository.ProductRepository;
import com.ricardomaricato.productservice.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insert(Product product) {
        return productRepository.save(product);
    }
}
