package com.example1.dto.response;

import java.util.List;

public class FoodCaloriesDTO {
    String name;
    int calories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
