package com.ricardomaricato.productservice.http.data.request;

import java.math.BigDecimal;

public class ProducPersistDto {

    private String description;

    private BigDecimal value;

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }
}
