package com.ricardomaricato.productservice.http.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.ricardomaricato.productservice.http.ProductController;
import com.ricardomaricato.productservice.http.data.request.ProducPersistDto;
import com.ricardomaricato.productservice.model.Product;
import com.ricardomaricato.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/")
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
        return productService.save(product);
    }

    @Override
    @GetMapping(value = "/{id}")
    public Product one(@PathVariable("id") Long id) {
        return productService.one(id);
    }

    @Override
    @PatchMapping(value = "/{id}")
    public Product update(@PathVariable("id") Long id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        Product product = productService.one(id);
        ObjectMapper objectMapper = new ObjectMapper()
                .disable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
                .enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)
                .setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));

        JsonNode productJsonNode = objectMapper.convertValue(product, JsonNode.class);
        JsonNode patchJsonNode = patch.apply(productJsonNode);
        Product productPersist = objectMapper.treeToValue(patchJsonNode, Product.class);
        return productService.save(productPersist);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }

    @PutMapping(value = "/{id}")
    public Product updateAll(@PathVariable("id") Long id, @RequestBody ProducPersistDto dto) {
        Product product = new Product(id ,dto.getDescription(), dto.getValue());
        return productService.update(product);
    }
}
