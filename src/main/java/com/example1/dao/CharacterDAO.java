package com.example1.dao;

import com.example1.dto.response.CharacterDTO;
import com.example1.dto.response.IngredientCaloriesDTO;

import java.util.List;

public interface CharacterDAO {
    List<CharacterDTO> getCharactersWhoMatchName(String name);
    List<CharacterDTO> getCharactersFromDB();
}
