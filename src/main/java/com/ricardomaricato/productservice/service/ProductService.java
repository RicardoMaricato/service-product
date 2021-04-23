package com.ricardomaricato.productservice.service;

import com.ricardomaricato.productservice.model.Product;

import java.util.List;

public interface ProductService {

    Product insert(Product product);

    Product one(Long id);

    List<Product> list();
}
