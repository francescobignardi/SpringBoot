package com.example.springboot.Esercizio4.dao;

import com.example.springboot.Esercizio2.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealDao extends JpaRepository<Meal, Long> {

}
