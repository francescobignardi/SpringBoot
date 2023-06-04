package com.example.springboot.Esercizio2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Exercise2 {

    @GetMapping("/meals")                                         // Esercizio 1
    public List meals() {
        List<Meal> pasti = Arrays.asList(
                new Meal("Pizza", 1000, 7.0),
                new Meal("Pasta", 500, 8.0),
                new Meal("Panino", 300, 4.5)
        );
        return pasti;
    }

    @RestController
    public class parte2 {
        @GetMapping("/meal/{name}")
        public Meal pastiPerNome(@PathVariable("name") String name) {
            return null;
        }

    }
}
