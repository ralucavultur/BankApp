package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addTransaction(double transaction) {
        if (!doesTransactionExist(transaction)) {
            transactions.add(transaction);
            System.out.println("Transaction successfully added.");
        } else {
            System.out.println("Adding the transaction failed.");
        }
    }

    private boolean doesTransactionExist(double searchedTransaction) {
        for (int i = 0; i < transactions.size(); i++) {
            if (searchedTransaction == transactions.get(i)) {
                System.out.println("Transaction already exists.");
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
