package com.example.springboot.Esercizio4;

import org.springframework.stereotype.Component;

@Component
public class RestaurantConfig {

    private Double minPrice = 5.0;
    private Double todaysDiscount = 1.5;

    public RestaurantConfig(){}

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getTodaysDiscount() {
        return todaysDiscount;
    }

    public void setTodaysDiscount(Double todaysDiscount) {
        this.todaysDiscount = todaysDiscount;
    }
}
