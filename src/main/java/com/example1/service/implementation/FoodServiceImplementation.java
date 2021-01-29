package com.example1.service.implementation;

import com.example1.dao.implementation.IngredientDAO;
import com.example1.dto.response.FoodCaloriesDTO;
import com.example1.dto.request.FoodDTO;
import com.example1.dto.response.IngredientCaloriesDTO;
import com.example1.dto.request.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServiceImplementation implements com.example1.service.FoodService {
    @Autowired
    private IngredientDAO repository;
    private int getCaloriesOfIngredient(IngredientDTO ingredient){
        IngredientCaloriesDTO ingredientFromDB = repository.getFoodByName(ingredient.getName());
        return ingredientFromDB.getCalories();
    }
    @Override
    public FoodCaloriesDTO getFoodCalories(FoodDTO food) {
        int totalCalories = 0;
        for(IngredientDTO ingredient:food.getIngredients()){
            totalCalories+=getCaloriesOfIngredient(ingredient)*ingredient.getWeight();
        }
        FoodCaloriesDTO foodResponse = new FoodCaloriesDTO();
        foodResponse.setName(food.getName());
        foodResponse.setCalories(totalCalories);
        return foodResponse;
    }

    @Override
    public List<IngredientCaloriesDTO> getIngredientsCalories(FoodDTO food) {
        List<IngredientCaloriesDTO> ingredients = new ArrayList<>();
        for(IngredientDTO ingredient:food.getIngredients()){
            IngredientCaloriesDTO newIngredient = new IngredientCaloriesDTO();
            newIngredient.setName(ingredient.getName());
            newIngredient.setCalories(getCaloriesOfIngredient(ingredient)*ingredient.getWeight());
            ingredients.add(newIngredient);
        }
        return ingredients;
    }

    @Override
    public IngredientCaloriesDTO getMaxCaloriesIngredient(FoodDTO food) {
        IngredientCaloriesDTO maxCaloriesIngredient = new IngredientCaloriesDTO();
        maxCaloriesIngredient.setCalories(0);
        for(IngredientDTO ingredient:food.getIngredients()){
            int ingredientCalories = getCaloriesOfIngredient(ingredient);
            if(ingredientCalories>maxCaloriesIngredient.getCalories()){
                maxCaloriesIngredient.setCalories(ingredientCalories*ingredient.getWeight());
                maxCaloriesIngredient.setName(ingredient.getName());
            }
        }
        return maxCaloriesIngredient;
    }
}
