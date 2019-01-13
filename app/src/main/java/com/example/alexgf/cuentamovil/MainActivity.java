package com.example.alexgf.cuentamovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_description);
        et2 = (EditText)findViewById(R.id.txt_amount);
        tv1 = (TextView)findViewById(R.id.txt_total);
        btn1 = (Button)findViewById(R.id.btn_add);
    }

    public void addAmount(View view){
        String stringDesc = et1.getText().toString();
        String stringAmount = et2.getText().toString();

        float amount;

        if(stringAmount != null){
            amount = Float.parseFloat(stringAmount);
        }else {
            amount = 0;
        }

        String result = String.valueOf(amount);
        tv1.setText(result);
    }
}
