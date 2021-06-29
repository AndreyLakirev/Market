package org.sber.lakirev.market.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sber.lakirev.market.model.Product;
import org.sber.lakirev.market.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Product", description = "The Product API")
@RestController
@RequestMapping(value = ProductRestController.REST_URL, produces = APPLICATION_JSON_VALUE)
public class ProductRestController {
    public static final String REST_URL = "/rest/market/products";

    private final ProductService service;

    public ProductRestController (ProductService service) {
        this.service = service;
    }

    @ResponseStatus(value = CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Product add(@RequestBody Product product) {
        System.out.println(product);
        return service.add(product);
    }

    @Operation(summary = "Gets all products", tags = "product")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the products",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class)))
                    })
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Product> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Gets product by id", tags = "product")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the product",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class)))
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Did not find the product",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class))
                            )
                    }
            )
    })
    @GetMapping(value = "/id/{id}", produces = APPLICATION_JSON_VALUE)
    public Product getById (@PathVariable(name = "id") Integer id) {
        return service.getById(id);
    }

    @Operation(summary = "Gets products by status", tags = "product")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the products",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class)))
                    })
    })
    @GetMapping(value = "/status/{status}", produces = APPLICATION_JSON_VALUE)
    public List<Product> getByStatus (@PathVariable(name = "status") String status) { return service.getByStatus(status);}
}
