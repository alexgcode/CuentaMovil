package com.example.alexgf.cuentamovil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexgf.cuentamovil.api.ApiServices;
import com.example.alexgf.cuentamovil.api.Expense;
import com.example.alexgf.cuentamovil.api.ExpenseRespond;
import com.example.alexgf.cuentamovil.api.StatusPost;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;

    private Retrofit retrofit;
    private ApiServices apiServices;
    private static final String TAG = "GASTOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt_description);
        et2 = findViewById(R.id.txt_amount);
        tv1 = findViewById(R.id.txt_view11);

        /*
        SharedPreferences preferencias = getSharedPreferences("expenses", Context.MODE_PRIVATE);
        getExpenses = Float.parseFloat(preferencias.getString("amount","0"));
        */

        retrofit = new Retrofit.Builder()
                .baseUrl("http://3.93.246.120:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiServices = retrofit.create(ApiServices.class);
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


        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");



        Expense expense = new Expense(stringDesc, amount, formatter.format(currentDate));

        Call<StatusPost> call = apiServices.addExpense(expense);

        call.enqueue(new Callback<StatusPost>() {
            @Override
            public void onResponse(Call<StatusPost> call, Response<StatusPost> response) {

                if (!response.isSuccessful()){
                    tv1.setText("Code: " + response.code());
                    return;
                }

                StatusPost statusPost = response.body();
                Toast.makeText(getApplicationContext(), statusPost.getStatus(), Toast.LENGTH_SHORT).show();
                //tv1.setText(statusPost.getStatus());
            }

            @Override
            public void onFailure(Call<StatusPost> call, Throwable t) {
                tv1.setText(t.getMessage());
            }
        });



        /*
        getExpenses = getExpenses + amount;

        String totalExpenses = String.valueOf(getExpenses);

        SharedPreferences preferencias = getSharedPreferences("expenses", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString("amount", totalExpenses);
        obj_editor.commit();

        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
        */


    }

    private void obtenerDatos(){
        ApiServices service = retrofit.create(ApiServices.class);
        Call<ExpenseRespond> expenseRespondCall = service.getExpensesList();

        expenseRespondCall.enqueue(new Callback<ExpenseRespond>() {
            @Override
            public void onResponse(Call<ExpenseRespond> call, Response<ExpenseRespond> response) {
                if(response.isSuccessful()){
                    ExpenseRespond expenseRespond = response.body();
                    ArrayList<Expense> expenselist = expenseRespond.getResult();
                    for (int i=0; i<expenselist.size(); i++){
                        Expense e = expenselist.get(i);
                        Log.i(TAG, "Expense: " + e.getDescription());
                    }
                }else {
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ExpenseRespond> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
