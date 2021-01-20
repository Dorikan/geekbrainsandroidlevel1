package com.example.geekbrainsa1l1firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class choseCityFragment extends Fragment {

    AutoCompleteTextView autoCompleteTextViewCity;
    Button btnOk;
    String city;
    CheckBox moreInfo;
    View view1;

    static String cityKey = "city";
    static String checkBoxMoreInfoKey = "show more info?";
    String[] cities;
    List<String> cities_list;
    ArrayAdapter<String> cities_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chose_city, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        view1 = view;
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findViews(view1);
        btnOkSetOnClickListener(getActivity());
    }


    private void findViews(View view){
        btnOk = view.findViewById(R.id.buttonInputCity);
        autoCompleteTextViewCity = view.findViewById(R.id.textInputCity);
        moreInfo = view.findViewById(R.id.checkBoxMoreInfo);

        inputCitySetAdapter();
    }
    private boolean getInfo(){
        return moreInfo.isChecked();
    }
    private void inputCitySetAdapter(){
        cities = getResources().getStringArray(R.array.cities);
        cities_list = Arrays.asList(cities);
        cities_adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_dropdown_item_1line, cities_list);
        autoCompleteTextViewCity.setAdapter(cities_adapter);
    }
    private void btnOkSetOnClickListener(Activity activity) {
        View.OnClickListener oclBtnOk = v -> {
            city = autoCompleteTextViewCity.getText().toString();
            if(city.isEmpty()){
                Toast.makeText(activity, R.string.city_is_empty, Toast.LENGTH_LONG).show();
            }else if(!cities_list.contains(city)){
                Toast.makeText(activity, R.string.not_in_cities_array, Toast.LENGTH_LONG).show();
            }else{
                Intent intent = new Intent();
                intent.putExtra(cityKey, city);
                intent.putExtra(checkBoxMoreInfoKey, getInfo());
                activity.setResult(RESULT_OK, intent);
                activity.finish();
            }
        };

        btnOk.setOnClickListener(oclBtnOk);
    }

}
