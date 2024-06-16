package com.esercizio01.controllers;

import com.esercizio01.entities.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v2")
public class Controller {

    @GetMapping(path = "/ciao/{regione}")
    public User ciaoNomeTempoRegione(@PathVariable String regione,
                                     @RequestParam(required = true, defaultValue = "Ivan") String nome) {
        return new User(nome, regione);
    }

}