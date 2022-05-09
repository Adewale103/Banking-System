package VenoBank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Bank bank;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
    runApp();
    }

    private static void runApp(){
        System.out.println("Welcome!");

        System.out.println("Enter the name of the bank: ");

        String bankName = input.nextLine();

        bank = new Bank(bankName);

        boolean quit = false;

        while(!quit) {
            String prompt = ("""
                    Press:
                    1. --> To add a new branch
                    2. --> To add a new customer
                    3. --> To add customer transaction
                    4. --> To view a list of a selected branch customers
                    5. --> To quit""");

            System.out.println(prompt);
            try {
                int response = input.nextInt();
                input.nextLine();

                switch (response) {
                    case 1 -> addBranch();
                    case 2 -> addCustomer();
                    case 3 -> addTransaction();
                    case 4 -> viewListOfCustomers();
                    case 5 -> {
                        System.out.println("Thanks for building a banking system for us!");
                        System.out.println("With love from " + bankName + "!");
                        quit = true;
                    }
                    default -> runApp();
                }
                System.out.println();
            }
            catch (InputMismatchException e){runApp();}
        }
    }

    private static void viewListOfCustomers() {
        String response = " ";
        System.out.println("Enter branch name to view list of customers: ");
        String branchName = input.nextLine();

        System.out.println("Would you like to view transaction details too? (Enter: Yes or No)");
        String status =  input.nextLine().toLowerCase();
        if (status.equals("no")) {
            response = "false";
        } else {
            response = "true";
        }

        bank.listCustomer(branchName, Boolean.parseBoolean(response));

    }

    private static void addTransaction() {
        System.out.println("Enter branch name: ");
        String branchName = input.nextLine();

        System.out.println("Enter name of customer: ");
        String customerName = input.nextLine();

        System.out.println("Enter deposit amount");
        double depositAmount = input.nextDouble();
        input.nextLine();

        if(bank.addCustomerTransaction(branchName,customerName,depositAmount)) {
            System.out.println(+depositAmount + " has been added to "+customerName+ "'s account");
        }
        else System.out.println("Unsuccessful transaction! Kindly try again with valid details");
    }

    private static void addCustomer() {
        System.out.println("Enter the name of the branch the customer wishes to be added: ");
        String branchName = input.nextLine();

        System.out.println("Enter name of customer: ");
        String customerName = input.nextLine();

        System.out.println("Enter initial deposit amount");
        double depositAmount = input.nextDouble();
        input.nextLine();

        if(bank.addCustomer(branchName,customerName,depositAmount)) {
            System.out.println(customerName + " has been added to "+branchName+" branch with an initial deposit of "+depositAmount);
        }
        else System.out.println("Unsuccessful, could not add branch/customer.");
    }

    private static void addBranch() {
        System.out.println("Enter the name of the branch: ");
        String branchName = input.nextLine();

        if(bank.addBranch(branchName)){
            System.out.println(branchName+" has been added as a new branch!");
        }
        else System.out.println(branchName+" already exist!");
    }
}
