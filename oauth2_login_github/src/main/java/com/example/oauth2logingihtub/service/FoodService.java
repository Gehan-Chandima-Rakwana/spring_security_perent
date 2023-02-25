package com.example.oauth2logingihtub.service;

import com.example.oauth2logingihtub.entity.Food;
import com.example.oauth2logingihtub.exception.ItemNotFoundException;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    List<Food> findAll() throws ItemNotFoundException;

    Food addNewFood(Food food);

    Optional<Food> findByID(Long id) throws ItemNotFoundException;

    Food updateFood(Long id, Food food);

    boolean deleteFood(Long id);
}
