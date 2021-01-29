package com.example1.controller;

import com.example1.dto.response.FoodCaloriesDTO;
import com.example1.dto.request.FoodDTO;
import com.example1.dto.response.IngredientCaloriesDTO;
import com.example1.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService service;
    @PostMapping("/calories")
    public FoodCaloriesDTO getFoodCalories(@RequestBody FoodDTO food){
        return service.getFoodCalories(food);
    }
    @PostMapping("/ingredients/calories")
    public List<IngredientCaloriesDTO> getIngredientsCalories(@RequestBody FoodDTO food){
        return service.getIngredientsCalories(food);
    }
    @PostMapping("/max")
    public IngredientCaloriesDTO getMaxCaloriesIngredient(@RequestBody FoodDTO food){
        return service.getMaxCaloriesIngredient(food);
    }
}
