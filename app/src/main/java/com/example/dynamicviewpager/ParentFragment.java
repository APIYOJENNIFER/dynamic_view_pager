package com.example.dynamicviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class ParentFragment extends Fragment {
    private PagerAdapter adapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parent, container, false);
        viewPager = view.findViewById(R.id.viewpager);
        tabLayout = view.findViewById(R.id.tabLayout);
        setViewPager();
        return view;
    }

    private void setViewPager() {
        adapter = new PagerAdapter(getChildFragmentManager(), 1);
        viewPager.setAdapter(adapter);
    }

    public void addPages(FoodModel foodModel, String title) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", foodModel);
        ChildFragment fragmentChild = new ChildFragment();
        fragmentChild.setArguments(bundle);
        adapter.addFragment(fragmentChild, foodModel, title);
        if (adapter.getCount() > 0) {
            tabLayout.setupWithViewPager(viewPager);
        }
        adapter.notifyDataSetChanged();
    }
}