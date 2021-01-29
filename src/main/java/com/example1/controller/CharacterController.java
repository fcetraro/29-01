package com.example1.controller;

import com.example1.dto.request.FoodDTO;
import com.example1.dto.response.CharacterDTO;
import com.example1.dto.response.FoodCaloriesDTO;
import com.example1.dto.response.IngredientCaloriesDTO;
import com.example1.service.CharacterService;
import com.example1.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    private CharacterService service;
    @GetMapping("/find/{name}")
    public List<CharacterDTO> getFoodCalories(@PathVariable String name){

        return service.getCharacters(name);
    }
}
