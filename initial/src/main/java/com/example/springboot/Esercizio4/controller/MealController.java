package com.example.springboot.Esercizio4.controller;

import com.example.springboot.Esercizio2.Meal;
import com.example.springboot.Esercizio4.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class MealController {

    private MealService mealService;
    @Autowired
    private MealController(MealService mealService){
        this.mealService = mealService;
    }

    @GetMapping("/get/meals")
    public ResponseEntity<List<Meal>> getMeals(){
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PutMapping("/put/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){
        try {
            mealService.addMeal(meal);
            return ResponseEntity.ok("Meal added");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/meal/{mealName}")
    public ResponseEntity<String> deleteMeal(@PathVariable String mealName) {
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Meal deleted!");
    }
}
