package com.example.oauth2logingihtub.repository;

import com.example.oauth2logingihtub.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
