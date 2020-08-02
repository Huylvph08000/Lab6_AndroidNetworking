package com.example.lab6_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnFC, btnCF;
    EditText txtDegreesToConvert;
    TextView tvResult;
    private Boolean convertToFahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCF = findViewById(R.id.btnConvertCtoF);
        btnFC = findViewById(R.id.btnConvertFtoC);
        txtDegreesToConvert = findViewById(R.id.txtToConvert);
        tvResult = findViewById(R.id.tvResult);
        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToFahrenheit = false;
                renderResult();
            }
        });
        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToFahrenheit = true;
                renderResult();
            }
        });
    }

    private void renderResult() {
        String textValue = txtDegreesToConvert.getText().toString();
        Double value;

        if (textValue == "" || textValue.isEmpty()) {
            tvResult.setText("");
            return;
        }

        try {
            value = Double.valueOf(textValue);
        } catch (Exception e) {
            tvResult.setText(getResources().getString(R.string.conversion_error));
            return;
        }

        String result;

        if (convertToFahrenheit) {
            result = String.format("%s Celsius equals to %.2f Fahrenheit",textValue, value * 9 / 5 + 32);
        } else {
            result = String.format("%s Fahrenheit equals to %.2f Celsius", textValue, (value - 32) * 5 / 9);
        }
        tvResult.setText(result);
    }
}