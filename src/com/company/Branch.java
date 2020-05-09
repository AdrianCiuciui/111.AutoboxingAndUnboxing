package com.company;

import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList <Customer> clientsList = new ArrayList<>();
    private Bank bank;

    public Branch (String branchName, Bank bank) {
        this.branchName = branchName;
        this.bank = bank;
    }

    public Customer createNewCustomer (String customerName, ArrayList<Double> amount) {
        Branch currentBranch = new Branch(this.branchName, this.bank);
        Customer customerToReturn = new Customer (customerName, amount, currentBranch);

        this.clientsList.add(customerToReturn);
        return customerToReturn;
    }

    public Customer isClientInTheList (String branch) {
        for (int i = 0; i < this.getClientsList().size(); i++)
            if (this.getClientsList().get(i).getCustomerName().equals(branch))
                return this.getClientsList().get(i);
        return null;
    }

    public String getBranchName () {
        return this.branchName;
    }

    public ArrayList<Customer> getClientsList() {
        return this.clientsList;
    }
}