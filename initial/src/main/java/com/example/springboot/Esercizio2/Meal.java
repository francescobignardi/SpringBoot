package com.example.springboot.Esercizio2;

public class Meal {
    private String name;
    private Integer calories;
    private Double price;

    public Meal(String name, Integer calories, Double price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getCalories() {
        return calories;
    }

    public Double getPrice() {
        return price;
    }
}
