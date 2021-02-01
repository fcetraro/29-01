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
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Repository
public class CharacterDAO extends GenericDAO implements com.example1.dao.CharacterDAO {
    private final static String json = "starwars.json";
    @Override
    public List<CharacterDTO> getCharactersWhoMatchName(String name) {
        List<CharacterDTO> allCharacters = null;
        allCharacters = getCharactersFromDB();
        List<CharacterDTO> charactersMatch = null;
        if(allCharacters!=null){
            charactersMatch = allCharacters.stream()
                    .filter(c -> c.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)))
                    .collect(toList());
        }
        return charactersMatch;
    }

    @Override
    public List<CharacterDTO> getCharactersFromDB() {
        return getObjectFromJSON(json, CharacterDTO.class);
    }
}
