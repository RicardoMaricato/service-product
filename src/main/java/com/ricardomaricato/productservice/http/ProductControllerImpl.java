package com.ricardomaricato.productservice.http;

import com.ricardomaricato.productservice.http.data.request.ProducPersistDto;
import com.ricardomaricato.productservice.http.data.response.ProductResponseDto;
import com.ricardomaricato.productservice.model.Product;
import com.ricardomaricato.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product insert(@Valid @RequestBody ProducPersistDto dto) {
        Product product = new Product(dto.getDescription(), dto.getValue());
        return productService.insert(product);
    }

    @Override
    @GetMapping(value = "/{id}")
    public Product one(@PathVariable("id") Long id) {
        return productService.one(id);
    }

}
