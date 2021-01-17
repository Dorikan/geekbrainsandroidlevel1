package com.example.geekbrainsa1l1firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class choseCityLayout extends AppCompatActivity {

    EditText editTextCity;
    Button btnOk;
    String city;
    CheckBox moreInfo;

    static String cityKey = "city";
    static String checkBoxMoreInfoKey = "show more info?";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city_layout);
        findViews();
        btnOkSetOnClickListener();
    }

    private void btnOkSetOnClickListener() {
        View.OnClickListener oclBtnOk = v -> {
            city = editTextCity.getText().toString();

            Intent intent = new Intent();
            intent.putExtra(cityKey, city);
            intent.putExtra(checkBoxMoreInfoKey, getInfo());
            setResult(RESULT_OK, intent);
            finish();
        };

        btnOk.setOnClickListener(oclBtnOk);
    }
    private boolean getInfo(){
        return moreInfo.isChecked();
    }
    private void findViews(){
        btnOk = findViewById(R.id.buttonInputCity);
        editTextCity = findViewById(R.id.textInputCity);
        moreInfo = findViewById(R.id.checkBoxMoreInfo);
    }
}
