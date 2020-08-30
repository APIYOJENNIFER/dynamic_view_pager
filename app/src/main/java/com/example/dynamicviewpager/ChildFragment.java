package com.example.dynamicviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChildFragment extends Fragment {
    private FoodAdapter adapter;
    private List<FoodModel> foodModelList;
    private RecyclerView recyclerView;
    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child, container, false);
        foodModelList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerview);
        imageView = view.findViewById(R.id.imageView);
        setRecyclerview();
        setFoodItems();
        return view;
    }

    private void setRecyclerview() {
        recyclerView.setHasFixedSize(true);
        adapter = new FoodAdapter(foodModelList, getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private void setFoodItems() {
        assert getArguments() != null;
        FoodModel model = (FoodModel) getArguments().getSerializable("data");
        for (int i = 0; i <= 5; i++) {
            foodModelList.add(model);
        }
        imageView.setImageResource(R.drawable.chicken3);
    }
}