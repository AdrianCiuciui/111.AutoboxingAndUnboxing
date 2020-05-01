package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Bank ing = new Bank("ING");

    public static void main(String[] args) {

        System.out.println("Welcome to " + ing.getNameOfBank() + " Bank");
        Branch zorilor = ing.createNewBranch("Zorilor", ing);
        Branch cipariu = ing.createNewBranch("Cipariu", ing);
        Branch centru = ing.createNewBranch("Centru", ing);

        ArrayList<Double> amount = new ArrayList<>();        amount.add(2.55); amount.add(51.23); amount.add(102.25);
        Customer customer1 = zorilor.createNewCustomer("Adrian", amount);
        ArrayList<Double> amount2 = new ArrayList<>();         amount2.add(7.77); amount2.add(82.77); amount2.add(298.7);
        Customer customer2 = zorilor.createNewCustomer("Decebal", amount2);
        ArrayList<Double> amount3 = new ArrayList<>();         amount3.add(1.45);
        Customer customer3 = cipariu.createNewCustomer("Traian", amount3);



        while (true) {
            System.out.println("    Select type of menu you want to see: 1. Bank, 2. Client, 3. Quit app.");
            int menuType = scanner.nextInt();
            if (menuType == 1 || menuType == 2)
            switch (menuType) {
                case 1:
                    ing.bankMenu(ing);
                    bankMenu();
                    break;
                case 2:
                    clientMenu();
                    break;
            }
            else if (menuType == 3) break;
        }
    }


    private static void bankMenu () {
        while (true) {

            int bankMenuOption = scanner.nextInt(); scanner.nextLine();
            switch (bankMenuOption) {
                case 0: // add new branch
                    System.out.println("Please insert new branch name");
                    String newBranchName = scanner.nextLine();
                    ing.createNewBranch(newBranchName, ing);
                    break;
                case 1: // new customer + transaction
                    createFromMenuOptionANewCustomer();
                    break;
                case 2: // existing customer + transaction
                    addTransactionToExistingCustomer();
                    break;
                case 3: // list all customers
                    listAllCustomersFromAllBranches ();
                    break;
                case 4: // list all branches
                    System.out.println("The branches of " + ing.getNameOfBank() + " are:");
                    ing.listBranches();
                    break;
                case 5: return; // quit this menu
            }
        }
    }

    private static void clientMenu () {
        System.out.println("===*** Welcome to client menu. Nothing to see here for now ***===");
    }

    private static void createFromMenuOptionANewCustomer() {
        System.out.println("Please select your branch");
        ing.listBranches();
        int selectedBranch = scanner.nextInt(); scanner.nextLine();
        System.out.println("Please insert the customer's name");
        String newCustomerName = scanner.nextLine();
        System.out.println("Please insert the amount traded");
        Double initialAmount = scanner.nextDouble(); scanner.nextLine();
        Customer thisCustomer = new Customer (newCustomerName, createTransactionsList(initialAmount), ing.selectBranch(selectedBranch));
        Branch branch = ing.selectBranch(selectedBranch);
        branch.getClientsList().add(thisCustomer);
    }

    private static void addTransactionToExistingCustomer () {
        System.out.println("Please enter your Branch");
        String clientBranch = scanner.nextLine();

        System.out.println("Please enter your name");
        String clientName = scanner.nextLine();

        System.out.println("Please enter the amount you want to trade");

    }

    private static void listAllCustomersFromAllBranches () {
        ArrayList<Branch> branches = ing.getBranchArrayList();
        for (int i = 0; i < branches.size(); i++) {
            System.out.println("===>   Branch " + branches.get(i).getBranchName());

            ArrayList<Customer> customers = ing.getBranchArrayList().get(i).getClientsList();
            for ( int j = 0; j < customers.size(); j ++) {
                System.out.println("=>  Customer " + customers.get(j).getCustomerName());
                System.out.println("> With payments: ");

                ArrayList <Double> amount = ing.getBranchArrayList().get(i).getClientsList().get(j).getDoubleArrayList();
                for (int k = 0; k < amount.size(); k++) {
                    System.out.println(amount.get(k));
                }
            }
        }
        System.out.println("        end of the list ===");
    }

    public static ArrayList <Double> createTransactionsList (Double value) {
         ArrayList<Double> transactionList = new ArrayList<>();
         transactionList.add(value);
         return transactionList;
    }
}