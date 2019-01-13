package com.example.alexgf.cuentamovil;

import android.content.Intent;
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

        String expense = getIntent().getStringExtra("expense");
        tv1.setText(expense);
    }

    public void addIncome(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void addSpend(View view){

    }
}
