package com.example.formbasedauthjdbc.repository;

import com.example.formbasedauthjdbc.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}