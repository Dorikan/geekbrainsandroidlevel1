
package com.example.geekbrainsa1l1firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textViewCity;
    Button btnOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        btnOkSetOnClickListener();
    }

    private void btnOkSetOnClickListener() {
        View.OnClickListener oclBtnOk = v -> textViewCity.setText(editText.getText().toString());
        btnOk.setOnClickListener(oclBtnOk);
    }

    private void findViews() {
        editText = findViewById(R.id.textInputCity);
        textViewCity = findViewById(R.id.usersCityFromEditText);
        btnOk = findViewById(R.id.buttonInputCity);
    }
}