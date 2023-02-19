package com.example.thymeleafcrud.service;

import com.example.thymeleafcrud.entity.Food;
import com.example.thymeleafcrud.exception.ItemNotFoundException;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    List<Food> findAll() throws ItemNotFoundException;

    Food addNewFood(Food food);

    Optional<Food> findByID(Long id) throws ItemNotFoundException;

    Food updateFood(Long id, Food food);

    boolean deleteFood(Long id);
}
