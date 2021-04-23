package com.ricardomaricato.productservice.http.data.response;

public class ProductResponseDto {

    private Long id;
    private String description;

    public ProductResponseDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
