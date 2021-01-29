package com.example1.service;

import com.example1.dto.response.FoodCaloriesDTO;
import com.example1.dto.request.FoodDTO;
import com.example1.dto.response.IngredientCaloriesDTO;

import java.util.List;

public interface FoodService {
    FoodCaloriesDTO getFoodCalories(FoodDTO food);
    List<IngredientCaloriesDTO> getIngredientsCalories(FoodDTO food);
    IngredientCaloriesDTO getMaxCaloriesIngredient(FoodDTO food);
}
