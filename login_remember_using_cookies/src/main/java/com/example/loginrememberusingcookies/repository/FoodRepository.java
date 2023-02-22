package com.example.loginrememberusingcookies.repository;

import com.example.loginrememberusingcookies.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
