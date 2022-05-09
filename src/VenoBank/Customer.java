package VenoBank;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;


    public Customer(String name, double initialAmount) {
        this.name = name;
        transactions = new ArrayList<>();
        transactions.add(initialAmount);
    }
    public void addTransaction(double Amount){
        transactions.add(Amount);
    }
    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }


}
