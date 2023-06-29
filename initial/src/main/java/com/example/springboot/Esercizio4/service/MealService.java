package com.example.springboot.Esercizio4.service;

import com.example.springboot.Esercizio2.Meal;
import com.example.springboot.Esercizio4.RestaurantConfig;
import com.example.springboot.Esercizio4.dao.MealDao;

import com.example.springboot.Esercizio4.dao.MealDao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MealService {

    private MealDao1 mealDao1;

    private MealDao mealDao;

    private RestaurantConfig restaurantConfig;

    @Autowired
    public MealService(MealDao1 mealDao1, RestaurantConfig restaurantConfig, MealDao mealDao) {
        this.mealDao1 = mealDao1;
        this.restaurantConfig = restaurantConfig;
        this.mealDao = mealDao;
    }

    /**@Autowired
    public MealService(MealDao mealDao){
        this.mealDao = mealDao;
    }
    */


    public void addMeal(Meal meal){
        if(meal == null) throw new IllegalArgumentException("Meal cannot be null!");
        if(meal.getName() == null || meal.getName().isEmpty()) throw new IllegalArgumentException("Meal name cannot be null or empty!");
        if(meal.getDescription() == null || meal.getDescription().isEmpty()) throw new IllegalArgumentException("Meal description cannot be null or empty!");
        if(meal.getPrice() <= 0) throw new IllegalArgumentException("Meal price cannot be less than or equal to 0!");
        if(meal.getPrice() > 100) throw new IllegalArgumentException("Meal price cannot be greater that 100!");
        mealDao1.addMeal(meal);
    }
    public void deleteMeal(String mealName){
        mealDao1.deleteMeal(mealName);
    }
    public void updateMeal(Meal meal){
        mealDao1.updateMeal(meal);
    }


    public List<Meal> getMeals(){
        return mealDao1.getMeals();
    }
    public void insertMealTest(){
        mealDao.save(new Meal("Test meal", "Very tasty", 4.8));
    }
}
