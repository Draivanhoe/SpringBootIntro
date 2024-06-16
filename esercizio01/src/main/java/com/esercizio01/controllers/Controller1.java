package com.esercizio01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class Controller1 {

    @GetMapping(path = "/ciaoTempo")
    public String ciaoTempo(@RequestParam(value = "nome", required = true, defaultValue = "Ivan") String nome,
                            @RequestParam(value = "regione", required = true, defaultValue = "Calabria") String regione) {
        return "Ciao " + nome + ", com'è il tempo in " + regione + "?";
    }

}