package com.ricardomaricato.productservice.http.data.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProducPersistDto {

    @NotEmpty
    private String description;

    @NotNull
    private BigDecimal value;

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }
}
