package com.example.springboot.Esercizio2;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Exercise2 {

    @GetMapping("/meals")                                         // Esercizio 1
    public List<Meal> meals() {
        List<Meal> pasti = Arrays.asList(
                new Meal("Pizza", "Pomodoro, mozzarella, basilico", 7.0),
                new Meal("Pasta", "Rigatoni, uovo, pecorino, guanciale, pepe", 8.0),
                new Meal("Panino", "Baguette, salame, maionese", 4.5)
        );
        return pasti;
    }

    @RestController                                               // Esercizio 2
    public class parte2 {
        @GetMapping("/meal/{name}")
        public Meal pastiPerNome(@PathVariable String name) {
            Meal meal = null;
            for(Meal m : meals()){
                if(m.getName().equals(name)){
                    meal = m;
                }
            }
            return meal;
        }
    }

    @RestController                                            //Esercizio 3
    public class parte3 {
        @GetMapping("/meal/description-match/{description}")
        public Meal pastiDescription(@PathVariable String description){
            Meal meal = null;
            for(Meal m : meals()){
                List split = Arrays.stream((m.getDescription().split(" "))).map(s -> s.replaceAll(",", "")).toList();
                if(split.contains(description)){
                    meal = m;
                }
            }
            return meal;
        }
    }

    @RestController                                               // Esercizio 4
    public class parte4 {
        @GetMapping("meal/price")
        public List<Meal> pastiPriceRange(@RequestParam("maxPrice") Double max, @RequestParam("minPrice") Double min){
             List<Meal> result = new ArrayList<>();
             for(Meal m : meals()){
                 if(m.getPrice() <= max && m.getPrice() >= min){
                     result.add(m);
                 }
             }
             return result;
        }
    }
}
