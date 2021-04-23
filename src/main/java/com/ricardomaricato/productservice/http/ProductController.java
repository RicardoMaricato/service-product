package com.ricardomaricato.productservice.http;

import com.ricardomaricato.productservice.http.data.request.ProducPersistDto;
import com.ricardomaricato.productservice.http.data.response.ProductResponseDto;
import com.ricardomaricato.productservice.model.Product;
import com.ricardomaricato.productservice.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto insert(@RequestBody ProducPersistDto dto) {
        Product product = new Product(dto.getDescription(), dto.getValue());
        Product persist = productService.insert(product);
        return modelMapper.map(persist, ProductResponseDto.class);
    }

    @GetMapping(value = "/{id}")
    public ProductResponseDto one(@PathVariable("id") Long id) {
        var product = productService.one(id);
        return modelMapper.map(product, ProductResponseDto.class);
    }

    @GetMapping
    public ProductResponseDto list() {
        List<Product> products = productService.list();
        return modelMapper.map(products, ProductResponseDto.class);
    }
}
