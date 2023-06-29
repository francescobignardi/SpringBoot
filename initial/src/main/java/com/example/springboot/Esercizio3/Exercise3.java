package com.example.springboot.Esercizio3;

import com.example.springboot.Esercizio2.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Exercise3 {

private List<Meal> meals = new ArrayList<>();

    @GetMapping("/meals3")                          //Metodo per verificare i pasti presenti nella lista, non richiesto da Greg
    public ResponseEntity<List<Meal>> getMeals(){
        return ResponseEntity.ok(meals);
    }

    @PutMapping("/meal")
    public ResponseEntity<String> addMeal(@RequestBody Meal meal) {
        this.meals.add(meal);
        return ResponseEntity.ok("Pasto aggiunto");
    }

    @PostMapping("/meal/{name}")
    public ResponseEntity<String> updateMealByName(@PathVariable String name, @RequestBody Meal meal) {
        for (Meal m : meals) {
            if(m.getName().equals(name)){
                meals.remove(m);
                meals.add(meal);
            }
        }
    return ResponseEntity.ok("Pasto sostituito");
    }

    @DeleteMapping("meal/{name}")
    public ResponseEntity<String> deleteMealByName(@PathVariable String name){
        for(Meal m : meals){
            if(m.getName().equals(name)){
                meals.remove(m);
            }
        }
        return ResponseEntity.ok("Pasto eliminato");
    }

    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity<String> deleteMealAboveCertainPrice(@PathVariable Double price){
        for(Meal m : meals){
            if(m.getPrice() > price){
                meals.remove(m);
            }
        }
        return ResponseEntity.ok("Pasti con prezzo maggiore di quello inserito eliminati");
    }

    @PostMapping("meal/{name}/price")                                                           //Non va
    public ResponseEntity<String> updatePriceByName(@PathVariable String name, @RequestBody Meal meal){
        for(Meal m : meals){
            if(m.getName().equals(name) && m.getPrice() != meal.getPrice()){
                meals.remove(m);
                meals.add(meal);
            }
        }
        return ResponseEntity.ok("Prezzo del pasto selezionato aggiornato");
    }
}