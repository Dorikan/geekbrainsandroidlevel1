package com.example.geekbrainsa1l1firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class temperatureListFragment extends Fragment implements IRVDOnItemClick{

    private RecyclerView recyclerView;
    private ArrayList<String> listData;
    private dayListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.days_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        findViews(view);
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupRecyclerView(getActivity());
    }

    private void findViews(View view){
        listData = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.week_days)));

        recyclerView = view.findViewById(R.id.rvDaysTemperature);
    }
    private void setupRecyclerView(Activity activity){
        getTemperature();
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity.getBaseContext());
        adapter = new dayListAdapter(listData, this);

        DividerItemDecoration decorator = new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
        decorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.decorator));

        recyclerView.addItemDecoration(decorator);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void getTemperature(){
        //Временно значения бессмысленны.
        for(int i = 0; i<3; i++){
            String asArg = listData.get(i);
            String newText = asArg + "\n" + getResources().getString(R.string.expected_temperature) + " z";

            listData.remove(i);
            listData.add(i, newText);
        }
    }

    @Override
    public void onItemClick(String itemText) {

    }
}
