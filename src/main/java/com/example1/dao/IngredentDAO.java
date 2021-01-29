package com.example1.dao;

import com.example1.dto.response.IngredientCaloriesDTO;
import java.util.List;

public interface IngredentDAO {
    IngredientCaloriesDTO getFoodByName(String name);
    List<IngredientCaloriesDTO> getFoodsFromDB();
}
