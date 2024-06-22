package com.esercizio05.dependencies;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class NameController {

    @GetMapping
    @RequestMapping(path = "/{name}")
    //@CrossOrigin(origins = "http://example.com")
    public String getName(@PathVariable String name) {
        return name;
    }

    @GetMapping
    @RequestMapping(path = "/reverse")
    //@CrossOrigin(origins = "http://127.0.0.1:8080")
    public String getReversedName(@RequestParam String name) {
        if (name == null) {
            return null;
        }

        StringBuilder reversedName = new StringBuilder(name).reverse();
        return reversedName.toString();
    }

}