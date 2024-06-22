package com.esercizio04.dependencies;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class NameController {

    @GetMapping
    @Operation(summary = "Restituisce la stringa fornita")
    @RequestMapping(path = "/{name}")
    public String getName(@Parameter(description = "Stringa da restituire", example = "Gianpaolo")
            @PathVariable String name) {
        return name;
    }

    @GetMapping
    @Operation(summary = "Inverte l'ordine dei caratteri della stringa fornita")
    @RequestMapping(path = "/reverse{name}")
    public String getReversedName(@Parameter(description = "Stringa da invertire", example = "Ivan")
            @PathVariable String name) {
        if (name == null) {
            return null;
        }

        StringBuilder reversedName = new StringBuilder(name).reverse();
        return reversedName.toString();
    }

}