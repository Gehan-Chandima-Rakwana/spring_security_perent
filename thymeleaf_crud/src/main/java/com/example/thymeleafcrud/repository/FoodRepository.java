package com.example.thymeleafcrud.repository;

import com.example.thymeleafcrud.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
