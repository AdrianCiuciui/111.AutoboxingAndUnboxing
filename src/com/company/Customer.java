package com.company;

import java.util.ArrayList;

public class Customer {

    private String customerName;
    private ArrayList <Double> doubleArrayList;
    private Branch branch;

    public Customer(String customerName, ArrayList <Double> doubleArrayList, Branch branch) {
        this.customerName = customerName;
        this.doubleArrayList = doubleArrayList;
        this.branch = branch;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public ArrayList<Double> getDoubleArrayList() {
        return this.doubleArrayList;
    }
}
