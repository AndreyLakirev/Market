package org.sber.lakirev.market.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sber.lakirev.market.model.Product;
import org.sber.lakirev.market.model.Purchase;
import org.sber.lakirev.market.service.PurchaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Purchase", description = "The Product API")
@RestController
@RequestMapping(value = PurchaseRestController.REST_URL, produces = APPLICATION_JSON_VALUE)
public class PurchaseRestController {
    public static final String REST_URL = "/rest/market/purchases";

    private final PurchaseService service;

    public PurchaseRestController (PurchaseService service) {
        this.service = service;
    }

    @ResponseStatus(value = CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Purchase add(@RequestBody Purchase purchase) {
        System.out.println(purchase);
        return service.add(purchase);
    }

    @Operation(summary = "Gets all purchases", tags = "purchase")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the purchases",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Purchase.class)))
                    })
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Purchase> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Gets purchase by id", tags = "purchase")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the purchase",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class)))
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Did not find the purchase",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class))
                            )
                    }
            )
    })
    @GetMapping(value = "/id/{id}", produces = APPLICATION_JSON_VALUE)
    public Purchase getById (@PathVariable(name = "id") Integer id) {
        return service.getById(id);
    }
}
