package com.ricardomaricato.productservice.http;

import com.ricardomaricato.productservice.http.data.request.ProducPersistDto;
import com.ricardomaricato.productservice.http.data.response.ProductResponseDto;
import com.ricardomaricato.productservice.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface ProductController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Product insert(@Valid @RequestBody ProducPersistDto dto);

    @Operation(summary = "Returns the product corresponding to the identifier retrieved by parameter")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "404",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "\"code\": \"X_100\",\n" +
                                            "\"message\": \"Code product %d not found\",\n" +
                                            "\"documentation\": null\n" +
                                            "}"
                            )
                    )
            )
    })
    @GetMapping(value = "/{id}")
    Product one(@PathVariable("id") Long id);
}
