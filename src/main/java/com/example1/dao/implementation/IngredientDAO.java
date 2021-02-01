package com.example1.dao.implementation;

import com.example1.dao.IngredentDAO;
import com.example1.dto.response.CharacterDTO;
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
public class IngredientDAO extends GenericDAO implements IngredentDAO {

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
        return getObjectFromJSON("food.json", IngredientCaloriesDTO.class);
    }
}
