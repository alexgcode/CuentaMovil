package com.example.alexgf.cuentamovil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private float getExpenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_description);
        et2 = (EditText)findViewById(R.id.txt_amount);

        SharedPreferences preferencias = getSharedPreferences("expenses", Context.MODE_PRIVATE);
        getExpenses = Float.parseFloat(preferencias.getString("amount","0"));
    }

    public void addAmount(View view){
        String stringDesc = et1.getText().toString();   //text of description
        String stringAmount = et2.getText().toString(); //text of amount

        float amount;

        if(stringAmount != null){
            amount = Float.parseFloat(stringAmount);
        }else {
            amount = 0;
        }

        getExpenses = getExpenses + amount;

        String totalExpenses = String.valueOf(getExpenses);

        SharedPreferences preferencias = getSharedPreferences("expenses", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString("amount", totalExpenses);
        obj_editor.commit();

        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }
}
