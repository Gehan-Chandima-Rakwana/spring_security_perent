package com.example.formbasedauthjdbc.service;

import com.example.formbasedauthjdbc.entity.Food;
import com.example.formbasedauthjdbc.exception.ItemNotFoundException;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    List<Food> findAll() throws ItemNotFoundException;

    Food addNewFood(Food food);

    Optional<Food> findByID(Long id) throws ItemNotFoundException;

    Food updateFood(Long id, Food food);

    boolean deleteFood(Long id);
}
