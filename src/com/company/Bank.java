package com.company;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches = new ArrayList<>();

    public void addCustomer(String branchName, String customerName, double initialTransaction) {
        if (doesBranchExist(branchName)) {
            Branch branch = branches.get(getBranchPosition(branchName));
            branch.addCustomer(customerName, initialTransaction);
        } else {
            System.out.println("No branch with this name was found");
        }
    }

    public void addTransaction(String branchName, String customerName, double newTransaction) {
        if (doesBranchExist(branchName)) {
            Branch branch = branches.get(getBranchPosition(branchName));
            branch.addTransactions(customerName, newTransaction);
        } else {
            System.out.println("No branch with this name was found");
        }
    }

    public void printListOfCustomers(String branchName) {
        if (doesBranchExist(branchName)) {
            Branch branch = branches.get(getBranchPosition(branchName));
            System.out.println("The list of customers for branch " + branchName + " are:");
            branch.printCustomerListWithoutTransactions();
        } else {
            System.out.println("No branch with this name was found");
        }

    }

    public void printListOfCustomersWithTransactions(String branchName) {
        if (doesBranchExist(branchName)) {
            Branch branch = branches.get(getBranchPosition(branchName));
            System.out.println("The list of customers for branch: " + branchName + ", with their transactions are:");
            branch.printCustomerListWithTransactions();
        } else {
            System.out.println("No branch with this name was found");
        }
    }


    public void addBranch(String name) {
        Branch newBranch = new Branch(name);
        if (!doesBranchExist(newBranch)) {
            branches.add(newBranch);
            System.out.println("Branch successfully added.");
        } else {
            System.out.println("Branch already exists.");
        }
    }

    public void printBranchList() {
        for (int i = 0; i < branches.size(); i++) {
            System.out.println((i + 1) + ". " + this.branches.get(i).getName());
        }
    }

    private boolean doesBranchExist(Branch searchedBranch) {
        for (int i = 0; i < branches.size(); i++) {
            if (searchedBranch.getName().equals(branches.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean doesBranchExist(String name) {
        if (getBranchPosition(name) == -1) {
            return false;
        } else {
            return true;
        }
    }

    private int getBranchPosition(String name) {
        for (int i = 0; i < branches.size(); i++) {
            if (name.equals(branches.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public void findCustomer(String name) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).hasCustomer(name)) {
                System.out.println("customer: " + name + ", found in branch: " + branches.get(i).getName());
            } else {
                System.out.println(name + " was not found");
                break;
            }
        }
    }
}