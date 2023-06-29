package com.example.springboot.Esercizio5.controller;

import com.example.springboot.Esercizio5.entity.Ingredient;
import com.example.springboot.Esercizio5.entity.Meal;
import com.example.springboot.Esercizio5.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {

    @Autowired
    public MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/insertMeal")
    public ResponseEntity<?> insertMeal(@RequestBody Meal meal){
        mealService.insertMeal(meal);
        return ResponseEntity.ok("Pasto inserito");
    }

    @GetMapping("/findById/{mealId}")
    public ResponseEntity<?> getMealById(@PathVariable("mealId") Long id){
        return ResponseEntity.ok().body(mealService.getMealById(id));
    }

    @GetMapping("/getAllMeals")
    public List<Meal> getAllMeals(){
        return mealService.getAllMeals();
    }

    @DeleteMapping("/deleteMeal/{mealId}")
    public ResponseEntity<?> deleteMeal(@PathVariable("mealId") Long id){
        mealService.deleteMeal(id);
        return ResponseEntity.ok("Pasto eliminato");
    }

    @PutMapping("/updateMeal/{mealId}")
    public ResponseEntity<?> updateMeal(@RequestBody Meal meal, @PathVariable("mealId") Long id){
        mealService.updateMeal(meal, id);
        return ResponseEntity.ok("Pasto modificato");
    }
}
