package com.example.dynamicviewpager;

import java.io.Serializable;

public class FoodModel implements Serializable {
    private String foodName;

    public FoodModel() {
    }

    public FoodModel(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
