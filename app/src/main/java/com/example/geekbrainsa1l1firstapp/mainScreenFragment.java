package com.example.geekbrainsa1l1firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.geekbrainsa1l1firstapp.choseCityLayout.checkBoxMoreInfoKey;
import static com.example.geekbrainsa1l1firstapp.choseCityLayout.cityKey;

public class mainScreenFragment extends Fragment {

    TextView textViewCity;
    TextView textViewPressure;
    Button btnSelect;

    String cityTextViewKey = "cityTextView";
    String pressureVisibilityKey = "pressureVisibility";
    boolean setVisible = false;

    private final int choseCityRequestCode = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_screen_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null){
            textViewCity.setText(savedInstanceState.getString(cityTextViewKey));
            setVisible = savedInstanceState.getBoolean(pressureVisibilityKey);
            checkPressureVisibility();
        }
        btnOkSetOnClickListener();
    }



    private void findViews(View view) {
        textViewCity = view.findViewById(R.id.usersCityFromEditText);
        textViewPressure = view.findViewById(R.id.textViewPressure);

        btnSelect = view.findViewById(R.id.buttonGoToSelectCity);
    }
    private void choseCityScreen(){
        Intent intentScreen = new Intent(getActivity(), choseCityLayout.class);
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
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(cityTextViewKey, textViewCity.getText().toString());
        outState.putBoolean(pressureVisibilityKey, setVisible);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == getActivity().RESULT_OK && requestCode == choseCityRequestCode){
            assert data != null;
            textViewCity.setText(data.getStringExtra(cityKey));
            setVisible = data.getBooleanExtra(checkBoxMoreInfoKey, false);
            checkPressureVisibility();
        }
    }
}

