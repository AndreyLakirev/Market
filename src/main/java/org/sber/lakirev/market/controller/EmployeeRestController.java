package org.sber.lakirev.market.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sber.lakirev.market.model.Employee;
import org.sber.lakirev.market.model.Product;
import org.sber.lakirev.market.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Employee", description = "The employee API")
@RestController
@RequestMapping(value = EmployeeRestController.REST_URL, produces = APPLICATION_JSON_VALUE)
public class EmployeeRestController {
    public static final String REST_URL = "/rest/market/employees";

    private final EmployeeService service;

    public EmployeeRestController (EmployeeService service) {
        this.service = service;
    }

    @ResponseStatus(value = CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Employee add(@RequestBody Employee employee) {

        return service.add(employee);
    }

    @Operation(summary = "Gets all employees", tags = "employee")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the employees",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Employee.class)))
                    })
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Employee> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Gets employee by id", tags = "employee")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the employee",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class)))
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Did not find the employee",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class))
                            )
                    }
            )
    })
    @GetMapping(value = "/id/{id}", produces = APPLICATION_JSON_VALUE)
    public Employee getById (@PathVariable(name = "id") Integer id) {
        return service.getById(id);
    }

    @Operation(summary = "Gets employees by status", tags = "employee")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the employees",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Employee.class)))
                    })
    })
    @GetMapping(value = "/status/{status}", produces = APPLICATION_JSON_VALUE)
    public List<Employee> getByStatus (@PathVariable(name = "status") String status) {
        return service.getByStatus(status);
    }
}
