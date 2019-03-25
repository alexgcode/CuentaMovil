package com.example.alexgf.cuentamovil.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiServices {

    String API_ROUTE = "expenses";
    String ADD_EXPENSE = "addexpense";

    @GET(API_ROUTE)
    Call<ExpenseRespond> getExpensesList();

    @POST(ADD_EXPENSE)
    Call<StatusPost> addExpense(@Body Expense expense);
}
