package com.example1.service.implementation;

import com.example1.dao.CharacterDAO;
import com.example1.dao.implementation.IngredientDAO;
import com.example1.dto.request.FoodDTO;
import com.example1.dto.request.IngredientDTO;
import com.example1.dto.response.CharacterDTO;
import com.example1.dto.response.FoodCaloriesDTO;
import com.example1.dto.response.IngredientCaloriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImplementation implements com.example1.service.CharacterService {
    @Autowired
    private CharacterDAO repository;

    @Override
    public List<CharacterDTO> getCharacters(String name) {
        return repository.getCharactersWhoMatchName(name);
    }
}
