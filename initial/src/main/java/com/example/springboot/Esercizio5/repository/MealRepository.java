package com.example.springboot.Esercizio5.repository;

import com.example.springboot.Esercizio5.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
}
