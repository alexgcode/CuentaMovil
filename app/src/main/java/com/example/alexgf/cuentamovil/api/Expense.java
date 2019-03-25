package com.example.alexgf.cuentamovil.api;

import java.util.Date;

public class Expense {
    private int id;
    private String description;
    private Float amount;
    private Date date;

    public Expense(String description, Float amount) {
        this.description = description;
        this.amount = amount;
    }

    public Expense(String description, Float amount, Date date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
