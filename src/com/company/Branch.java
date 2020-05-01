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

    public Branch (String branchName, ArrayList<Customer> clientsList, Bank bank) {
        this.branchName = branchName;
        this.clientsList = clientsList;
        this.bank = bank;
    }

    public Customer createNewCustomer (String customerName, ArrayList<Double> amount) {
        Branch currentBranch = new Branch(this.branchName, this.bank);
        Customer customerToReturn = new Customer (customerName, amount, currentBranch);

        this.clientsList.add(customerToReturn);
        return customerToReturn;

//        if (!isCustomerRegistered(customerName)) {
//            Customer customerToReturn = new Customer (customerName, amountAsArrayL, currentBranch);
//            this.clientsList.add(customerToReturn);
//            return customerToReturn;
//        }
//        return null;
    }

    private boolean isNewCustomerAdded (Customer customer) {
        if (customer == null) return false;
        if (isCustomerRegistered(customer.getCustomerName())) {
            System.out.println("Customer already exists. No customer added.");
            return false;
        }
        else {
            this.clientsList.add(customer);
            return true;
        }
    }

    private boolean isCustomerRegistered (String clientName) {
        for (int i = 0; i < clientsList.size(); i++) {
            Customer client = clientsList.get(i);
            if (client.getCustomerName().equals(clientName))
                return true;
        }
    return false;
    }

    public String getBranchName () {
        return this.branchName;
    }


    public ArrayList<Customer> getClientsList() {
        return this.clientsList;
    }
}
