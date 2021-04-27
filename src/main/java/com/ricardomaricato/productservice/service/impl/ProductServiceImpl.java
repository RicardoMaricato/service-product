package com.ricardomaricato.productservice.service.impl;

import com.ricardomaricato.productservice.event.ProductPersistEvent;
import com.ricardomaricato.productservice.model.Product;
import com.ricardomaricato.productservice.repository.ProductRepository;
import com.ricardomaricato.productservice.service.ProductService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public ProductServiceImpl(ProductRepository productRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.productRepository = productRepository;
        this.applicationEventPublisher = applicationEventPublisher;
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
        Product productPersist = productRepository.save(product);
        applicationEventPublisher.publishEvent(new ProductPersistEvent(this, product));
        return productPersist;
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
        return save(product);
    }
}
