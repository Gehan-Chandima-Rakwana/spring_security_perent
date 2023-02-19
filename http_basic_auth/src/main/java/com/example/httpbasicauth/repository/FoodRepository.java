package com.example.httpbasicauth.repository;

import com.example.httpbasicauth.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
