package com.example.dynamicviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<FoodModel> foodModelList;
    private Context context;

    public FoodAdapter(List<FoodModel> foodModelList, Context context) {
        this.foodModelList = foodModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new FoodAdapter.FoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodModel model = foodModelList.get(position);
        holder.textView.setText(model.getFoodName());
        int count = position + 1;
        holder.count.setText(count+".");
    }

    @Override
    public int getItemCount() {
        return foodModelList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView textView, count;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.text);
            this.count = itemView.findViewById(R.id.count);
        }
    }
}

