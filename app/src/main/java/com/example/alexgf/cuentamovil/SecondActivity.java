package com.example.alexgf.cuentamovil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv1 = (TextView)findViewById(R.id.txt_day_expense);
        tv2 = (TextView)findViewById(R.id.txt_residue);

        SharedPreferences preferencias = getSharedPreferences("expenses", Context.MODE_PRIVATE);
        tv1.setText(preferencias.getString("amount",""));
    }

    public void addIncome(View view){

    }

    public void addSpend(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
