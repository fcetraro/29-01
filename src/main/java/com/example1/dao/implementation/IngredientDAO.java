package com.example1.dao.implementation;

import com.example1.dao.IngredentDAO;
import com.example1.dto.response.IngredientCaloriesDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientDAO implements IngredentDAO {

    @Override
    public IngredientCaloriesDTO getFoodByName(String name) {
        List<IngredientCaloriesDTO> ingredients = null;
        ingredients = getFoodsFromDB();
        IngredientCaloriesDTO ingredientFromDB = null;
        if(ingredients!=null){
            Optional<IngredientCaloriesDTO> item = ingredients.stream()
                    .filter(ingredientCaloriesDTO -> ingredientCaloriesDTO.getName().equals(name))
                    .findFirst();
            if(item.isPresent()) ingredientFromDB = item.get();
        }
        return ingredientFromDB;
    }

    @Override
    public List<IngredientCaloriesDTO> getFoodsFromDB() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientCaloriesDTO>> typeRef = new TypeReference<>(){};
        List<IngredientCaloriesDTO> foodCalories = null;
        try{
            foodCalories = objectMapper.readValue(file, typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
        return foodCalories;
    }
}
