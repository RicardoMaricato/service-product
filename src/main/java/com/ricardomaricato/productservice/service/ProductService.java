package com.ricardomaricato.productservice.service;

import com.ricardomaricato.productservice.model.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    Product one(Long id);

    List<Product> list();

    void delete(Long id);

    Product update(Product product);
}
