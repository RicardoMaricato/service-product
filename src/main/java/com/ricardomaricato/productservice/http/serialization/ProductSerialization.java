package com.ricardomaricato.productservice.http.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ricardomaricato.productservice.http.data.response.ProductResponseDto;
import com.ricardomaricato.productservice.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ProductSerialization extends JsonSerializer<Product> {

    private final ModelMapper modelMapper;

    public ProductSerialization(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void serialize(Product product, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        ProductResponseDto productResponseDto = modelMapper.map(product, ProductResponseDto.class);
        jsonGenerator.writeObject(productResponseDto);
    }
}
