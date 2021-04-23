package com.ricardomaricato.productservice.http.data.response;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class Error {

    private final String code;
    private final String message;
    private String documentation;

    public Error(@NonNull String code, @NonNull String message) {
        this.code = Objects.requireNonNull(code);
        this.message = Objects.requireNonNull(message);
        // todo
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDocumentation() {
        return documentation;
    }
}
