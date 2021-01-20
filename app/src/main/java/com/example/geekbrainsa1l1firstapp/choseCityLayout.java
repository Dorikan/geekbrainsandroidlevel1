package com.example.geekbrainsa1l1firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class choseCityLayout extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextViewCity;
    Button btnOk;
    String city;
    CheckBox moreInfo;

    static String cityKey = "city";
    static String checkBoxMoreInfoKey = "show more info?";
    String[] cities;
    List<String> cities_list;
    ArrayAdapter<String> cities_adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city_layout);
    }

}
