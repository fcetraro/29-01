package com.example1.dao.implementation;

import com.example1.dto.response.IngredientCaloriesDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenericDAO<T> {
    public List<T> getObjectFromJSON(String json, Class<T> tClass) {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:"+json);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass);
        List<T> list = null;
        try{
            list = objectMapper.readValue(file, listType);
        } catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
