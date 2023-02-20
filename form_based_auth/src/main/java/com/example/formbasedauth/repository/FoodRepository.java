package com.example.formbasedauth.repository;

import com.example.formbasedauth.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
