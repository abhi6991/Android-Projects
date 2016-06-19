package com.example.abhishek.dailybiller;

import java.io.Serializable;

/**
 * Created by ABHISHEK on 6/6/2016.
 */
public class DayDetails implements Serializable {
String date;
    String name;
    float price;
    int no;

    float amount;


    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getNo() {
        return no;
    }

    public float getAmount() {
        return amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return date;
    }
}
