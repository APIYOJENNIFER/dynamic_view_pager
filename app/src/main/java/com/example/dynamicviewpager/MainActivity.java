package com.example.dynamicviewpager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<FoodModel> foodModelList;
    private ParentFragment parentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foodModelList = new ArrayList<>();
        parentFragment = (ParentFragment) this.getSupportFragmentManager().findFragmentById(R.id.fragment);
        addRecipes();
    }

    private void addRecipes() {
        FoodModel foodModel = new FoodModel();
        for (int i = 0; i <= 2; i++) {
            foodModel.setFoodName(getString(R.string.dummy_text));
            foodModelList.add(foodModel);
            if (i == 0) {
                parentFragment.addPages(foodModel, "Chicken");
            }
            if (i == 1) {
                parentFragment.addPages(foodModel, "Pizza");
            }
            if (i == 2) {
                parentFragment.addPages(foodModel, "Beef Steak");
            }
        }
    }
}