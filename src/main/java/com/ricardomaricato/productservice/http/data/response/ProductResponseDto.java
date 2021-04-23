package com.ricardomaricato.productservice.http.data.response;

public class ProductResponseDto {

    private Long id;
    private String description;

    @Deprecated
    public ProductResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
