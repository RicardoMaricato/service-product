package com.ricardomaricato.productservice.service.impl;

import com.ricardomaricato.productservice.model.Product;
import com.ricardomaricato.productservice.repository.ProductRepository;
import com.ricardomaricato.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product one(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoResultException(String.format("Code product %d not found", id)));
    }

    @Override
    public List<Product> list() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new NoResultException(String.format("Code product %d not found", id));
        }
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        if (!productRepository.existsById(product.getId())) {
            throw new NoResultException(String.format("Code product %d not found", product.getId()));
        }
        return productRepository.save(product);
    }
}
