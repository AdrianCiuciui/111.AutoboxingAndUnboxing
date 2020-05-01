package com.company;

import java.util.ArrayList;

public class Bank {

    private String nameOfBank;
    private ArrayList<Branch> branchArrayList = new ArrayList<>();

    public Bank(String name) {
        this.nameOfBank = name;
    }


    public Branch selectBranch (int selectedBranch) {
        selectedBranch -= 1;
        return this.branchArrayList.get(selectedBranch);
    }

    public void listBranches () {
        for (int i = 0; i < this.branchArrayList.size(); i++)
            System.out.println( (i+1) + ". " + this.branchArrayList.get(i).getBranchName());
    }

    public void bankMenu (Bank bank) {
        System.out.println("=== Welcome to " + bank.nameOfBank + " bank menu: \n" +
                "0. Add a new branch to the bank    \n" +
                "1. Add new customer with his/hers first transaction    \n" +
                "2. Add transaction to existing customer    \n" +
                "3. Show list of all bank customers from all branches    \n" +
                "4. List all of " + bank.nameOfBank + "'s branches   \n" +
                "5. Go to the previous menu");
    }

    public Branch createNewBranch(String branchName, Bank bank) {
        Branch branch = new Branch(branchName, bank);
        if (isBranchAlreadyCreated(branchName)) {
            System.out.println("That branch already exists. No new branch added.");
            return null;
        } else {
            this.branchArrayList.add(branch);
            int indexOfBranch = this.branchArrayList.size() - 1;
            System.out.println(bank.nameOfBank + " has created a new branch named " +
                    this.branchArrayList.get(indexOfBranch).getBranchName() +
                    ". Will return to the menu.");
            return branch;
        }
    }

    private boolean isBranchAlreadyCreated(String branchNameCheck) {
        for (int i = 0; i < branchArrayList.size(); i++)
            if (this.branchArrayList.get(i).getBranchName().equals(branchNameCheck)) return true;
        return false;
    }

    public Branch branchInTheList(String branch) {
        for (int i = 0; i < this.branchArrayList.size(); i++)
            if (this.getBranchArrayList().get(i).getBranchName().equals(branch))
                return this.branchArrayList.get(i);
        return null;
    }

    public ArrayList<Branch> getBranchArrayList() {
        return branchArrayList;
    }

    public String getNameOfBank() {
        return this.nameOfBank;
    }
}
