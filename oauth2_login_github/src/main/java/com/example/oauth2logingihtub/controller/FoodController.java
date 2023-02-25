package com.example.oauth2logingihtub.controller;

import com.example.oauth2logingihtub.entity.Food;
import com.example.oauth2logingihtub.exception.ItemNotFoundException;
import com.example.oauth2logingihtub.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public String loadView(Model model) throws ItemNotFoundException {
        List<Food> foods = foodService.findAll();
        model.addAttribute("message","Food Service");
        model.addAttribute("foods",foods);
        return "food";
    }

    @GetMapping("/addView")
    public String addView(Model model) throws ItemNotFoundException {
        model.addAttribute("food", new Food());
        return "addFood";
    }

    @PostMapping("/addNewFood")
    public String addNewFood(Model model, @ModelAttribute("food") Food food){
        Food food1 = foodService.addNewFood(food);
        return "redirect:/food";
    }

    @GetMapping("/updateView/{id}")
    public String updateView(@PathVariable(name = "id") Long id,Model model) throws ItemNotFoundException {
        Optional<Food> food = foodService.findByID(id);
        model.addAttribute("message", "Update Food");
        if (food.isPresent())
            model.addAttribute("food",food);
        else
            model.addAttribute("food", new Food());
        return "updateFood";
    }

    @PostMapping("/updateNewFood/{id}")
    public String updateNewFood(@PathVariable(name = "id") Long id, Model model,@ModelAttribute("food") Food food){
        Food result = foodService.updateFood(id,food);
        return "redirect:/food";
    }

    @GetMapping("deleteFood/{id}")
    public String deleteFood(@PathVariable(name = "id") Long id,Model model){
        boolean result = foodService.deleteFood(id);
        return "redirect:/food";
    }
}
