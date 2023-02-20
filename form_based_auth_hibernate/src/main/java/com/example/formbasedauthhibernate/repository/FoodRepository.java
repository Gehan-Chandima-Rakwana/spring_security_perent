package com.example.formbasedauthhibernate.repository;

import com.example.formbasedauthhibernate.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
