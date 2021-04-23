package com.ricardomaricato.productservice.http;

import com.ricardomaricato.productservice.http.data.request.ProducPersistDto;
import com.ricardomaricato.productservice.http.data.response.ProductResponseDto;
import com.ricardomaricato.productservice.model.Product;
import com.ricardomaricato.productservice.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponseDto insert(@RequestBody ProducPersistDto dto) {
        Product product = new Product(dto.getDescription(), dto.getValue());
        Product persist = productService.insert(product);
        return new ProductResponseDto(persist.getId(), persist.getDescription());
    }
}
