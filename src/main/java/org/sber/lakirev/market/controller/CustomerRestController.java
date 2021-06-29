package org.sber.lakirev.market.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sber.lakirev.market.model.Customer;
import org.sber.lakirev.market.model.Employee;
import org.sber.lakirev.market.model.Product;
import org.sber.lakirev.market.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Customer", description = "The customer API")
@RestController
@RequestMapping(value = CustomerRestController.REST_URL, produces = APPLICATION_JSON_VALUE)
public class CustomerRestController {
    public static final String REST_URL = "/rest/market/customers";

    private final CustomerService service;

    public CustomerRestController (CustomerService service) {this.service = service;}

    @ResponseStatus(value = CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Customer add(@RequestBody Customer customer) {

        return service.add(customer);
    }

    @Operation(summary = "Gets all customers", tags = "customer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the customers",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Customer.class)))
                    })
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Customer> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Gets customer by id", tags = "customer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the customer",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class)))
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Did not find the customer",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class))
                            )
                    }
            )
    })
    @GetMapping(value = "/id/{id}", produces = APPLICATION_JSON_VALUE)
    public Customer getById (@PathVariable(name = "id") Integer id) {
        return service.getById(id);
    }
}
