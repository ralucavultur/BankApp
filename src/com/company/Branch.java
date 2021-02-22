package com.company;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    public void addCustomer(String name, double initialTransaction) {
        if (!doesCustomerExist(name)) {
            Customer newCustomer = new Customer(name);
            customers.add(newCustomer);
            newCustomer.addTransaction(initialTransaction);
            System.out.println("Customer successfully added.");
        } else {
            System.out.println("Customer already exists.");
        }
    }

    public void addTransactions(String name, double transaction) {
        if (doesCustomerExist(name)) {
            Customer customer = customers.get(getCustomerPosition(name));
            customer.addTransaction(transaction);
        } else {
            System.out.println("No customer with this name was found");
        }
    }

    public void printCustomerListWithoutTransactions() {
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i+1) + ". " + this.customers.get(i).getName());
        }
    }

    public void printCustomerListWithTransactions(){
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i+1)+ ". " + this.customers.get(i).getName());
            System.out.println(this.customers.get(i).getTransactions());
        }
    }

    private boolean doesCustomerExist(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (name.equals(customers.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCustomer(String name){
        return doesCustomerExist(name);
    }

    private int getCustomerPosition(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (name.equals(customers.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public String getName() {
        return name;
    }
}
