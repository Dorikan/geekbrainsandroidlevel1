
package com.example.geekbrainsa1l1firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.geekbrainsa1l1firstapp.choseCityLayout.checkBoxMoreInfoKey;
import static com.example.geekbrainsa1l1firstapp.choseCityLayout.cityKey;


public class MainActivity extends AppCompatActivity {

    TextView textViewCity;
    TextView textViewPressure;
    Button btnSelect;

    String cityTextViewKey = "cityTextView";
    String pressureVisibilityKey = "pressureVisibility";
    boolean setVisible = false;

    private final int choseCityRequestCode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        Log.d("INFO", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        btnOkSetOnClickListener();
    }

    @Override
    protected void onStart() {
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        Log.d("INFO", "onCrStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        Log.d("INFO", "onResume");
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(cityTextViewKey, textViewCity.getText().toString());
        outState.putBoolean(pressureVisibilityKey, setVisible);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textViewCity.setText(savedInstanceState.getString(cityTextViewKey));
        setVisible = savedInstanceState.getBoolean(pressureVisibilityKey);
        checkPressureVisibility();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        Log.d("INFO", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        Log.d("INFO", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d("INFO", "onDestroy");
        super.onDestroy();
    }

    private void findViews() {
        textViewCity = findViewById(R.id.usersCityFromEditText);
        textViewPressure = findViewById(R.id.textViewPressure);

        btnSelect = findViewById(R.id.buttonGoToSelectCity);
    }
    private void choseCityScreen(){
        Intent intentScreen = new Intent(MainActivity.this, choseCityLayout.class);
        startActivityForResult(intentScreen, choseCityRequestCode);
    }

    private void btnOkSetOnClickListener() {
        View.OnClickListener oclSelectBtn = v -> choseCityScreen();

        btnSelect.setOnClickListener(oclSelectBtn);
    }
    private void checkPressureVisibility(){
        if(setVisible){
            textViewPressure.setVisibility(View.VISIBLE);
        }else{
            textViewPressure.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == choseCityRequestCode){
            assert data != null;
            textViewCity.setText(data.getStringExtra(cityKey));
            setVisible = data.getBooleanExtra(checkBoxMoreInfoKey, false);
            checkPressureVisibility();
            }
        }
}