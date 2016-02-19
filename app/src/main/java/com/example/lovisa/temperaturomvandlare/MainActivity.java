package com.example.lovisa.temperaturomvandlare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public double temp;
    public double doubleConvTemp;
    public String convertedTemp;
    private EditText insert;
    private Button toCelsiusButton;
    private Button toFahrenheitButton;
    private String TAG = "Komma";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = (EditText) findViewById(R.id.insert);
        toCelsiusButton = (Button) findViewById(R.id.button_toCelsius);
        toFahrenheitButton = (Button) findViewById(R.id.button_toFahrenheit);


        toFahrenheitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
            getInsert();
               toFahrenheit(temp);
                insert.setText(convertedTemp);
            }
                catch (Exception noTempInsert){
                    Toast.makeText(MainActivity.this, "Enter a temperature to convert", Toast.LENGTH_SHORT).show();
                }}
        });
        toCelsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
            getInsert();
                toCelsius(temp);
                insert.setText(convertedTemp);
                }
                catch (Exception noTempInsert){
                    Toast.makeText(MainActivity.this, "Enter a temperature to convert", Toast.LENGTH_SHORT).show();
                }
            }
        });


}

    private double getInsert(){
        String tempString;
        tempString = insert.getText().toString();
        tempString = tempString.replace(",", ".");
        Double tempComma = Double.parseDouble(tempString);
        DecimalFormat df = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
       temp = Double.valueOf(df.format(tempComma));
        return temp;

    }

    private String toCelsius(double temp){
       doubleConvTemp = (temp - 32)*5/9;
        DecimalFormat df = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
        doubleConvTemp = Double.valueOf(df.format(doubleConvTemp));
        convertedTemp = String.format("%.2f", doubleConvTemp);
        return convertedTemp;
    }

    private String toFahrenheit(double temp){
        doubleConvTemp = (temp*9/5) +32;
        DecimalFormat df = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
        doubleConvTemp = Double.valueOf(df.format(doubleConvTemp));
        convertedTemp = String.format("%.2f", doubleConvTemp);
        return convertedTemp;
    }
}
