package com.example.alexgf.cuentamovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_description);
        et2 = (EditText)findViewById(R.id.txt_amount);

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

        String expense = String.valueOf(amount);

        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("expense",expense);
        startActivity(i);
    }
}
