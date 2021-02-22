package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        printInstructions();
        int choice;
        boolean quit = false;
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    addBranch();
                    break;
                case 2:
                    findBranch();
                    break;
                case 3:
                    addCustomer();
                    break;
                case 4:
                    addTransaction();
                    break;
                case 5:
                    findCustomer();
                    break;
                case 6:
                    bank.printBranchList();
                    break;
                case 7:
                    printCustomersListWithoutTransactions();
                    break;
                case 8:
                    printCustomersListWithTransactions();
                    break;
                case 9:
                    quit = true;
                    break;
            }
        }

    }

    public static void printInstructions() {
        System.out.println("\n 0 - To print instructions" +
                "\n 1 - To add a new branch." +
                "\n 2 - To find a branch" +
                "\n 3 - To add a new customer" +
                "\n 4 - To add a new transaction to an existent customer" +
                "\n 5 - To find a customer" +
                "\n 6 - To print branches list" +
                "\n 7 - To print list of customers without transactions" +
                "\n 8 - To print list of customers with their transactions" +
                "\n 9 - Quit application");

    }

    public static void addBranch() {
        System.out.println("Enter branch name: ");
        String name = scanner.nextLine();
        bank.addBranch(name);
    }

    public static void addCustomer() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        if (bank.doesBranchExist(branchName)) {
            System.out.println("Enter customers name: ");
            String customerName = scanner.nextLine();
            System.out.println("Enter the amount of money for the first transaction: ");
            double firstTransaction = scanner.nextDouble();
            scanner.nextLine();
            bank.addCustomer(branchName, customerName, firstTransaction);
        } else System.out.println("No branch with this name found.");
    }

    public static void addTransaction() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        System.out.println("Enter customers name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter the amount of money: ");
        double newTransaction = scanner.nextDouble();
        scanner.nextLine();
        bank.addTransaction(branchName, customerName, newTransaction);
    }

    public static void findBranch() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        if (bank.doesBranchExist(branchName)) {
            System.out.println("Find branch.");
        } else {
            System.out.println("No branch with this name found.");
        }

    }

    public static void findCustomer() {
        System.out.println("Enter customers name: ");
        String customerName = scanner.nextLine();
        bank.findCustomer(customerName);
    }


    public static void printCustomersListWithTransactions() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        bank.printListOfCustomersWithTransactions(branchName);

    }

    public static void printCustomersListWithoutTransactions() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        bank.printListOfCustomers(branchName);
    }
}
