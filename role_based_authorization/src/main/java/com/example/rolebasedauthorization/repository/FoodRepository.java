package com.example.rolebasedauthorization.repository;

import com.example.rolebasedauthorization.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
