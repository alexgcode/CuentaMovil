package com.example.alexgf.cuentamovil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivity extends AppCompatActivity {

    private TextView tv1, tv2;
    private Float expense, residue, income;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv1 = (TextView)findViewById(R.id.txt_day_expense);
        tv2 = (TextView)findViewById(R.id.txt_residue);

        SharedPreferences preferencias = getSharedPreferences("expenses", Context.MODE_PRIVATE);
        expense = Float.parseFloat(preferencias.getString("amount","0"));

        SharedPreferences pref = getSharedPreferences("residue", Context.MODE_PRIVATE);
        income = Float.parseFloat(pref.getString("amount","0"));

        residue = income - expense;

        tv1.setText(String.valueOf(expense));
        tv2.setText(String.valueOf(residue));
    }

    public void addIncome(View view){
        Intent i = new Intent(this, ThirdActivity.class);
        startActivity(i);
    }

    public void addSpend(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
