package com.example.springboot.Esercizio5.service;


import com.example.springboot.Esercizio5.entity.Ingredient;
import com.example.springboot.Esercizio5.entity.Meal;
import com.example.springboot.Esercizio5.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {

    @Autowired
    public MealRepository mealRep;

    public void insertMeal(Meal meal){
        mealRep.save(meal);
    }

    public Meal getMealById(Long id){
        return mealRep.findById(id).get();
    }

    public List<Meal> getAllMeals(){
        List<Meal> pasti = new ArrayList<Meal>();
        pasti.addAll(mealRep.findAll());
        return pasti;
    }

    public void deleteMeal(Long id){
        mealRep.deleteById(id);
    }

    public void updateMeal (Meal meal, Long id){
        mealRep.deleteById(id);
        mealRep.save(meal);
    }
}
