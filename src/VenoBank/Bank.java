package VenoBank;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }
    private Branch findBranch(String branchName){
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            if (branch.getName().equals(branchName)){
                return branch;
            }
        }
        return null;
    }

    public boolean addBranch(String branchName){
        Branch branch = findBranch(branchName);
        if(branch == null){
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if(branch != null){
            branch.addCustomer(customerName,initialAmount);
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            branch.addCustomerTransaction(customerName,amount);
            return true;
        }
        return false;
    }

    public void listCustomer(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if(branch != null){
            System.out.println("Here is a list of customers in "+branch.getName()+" branch...");
            ArrayList<Customer> customers = branch.getCustomers();
            for (int i = 0; i < customers.size(); i++) {
                System.out.println("Customer "+(i+1)+". "+customers.get(i).getName());
                if(showTransactions){
                    ArrayList<Double> transactions = customers.get(i).getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println((j+1)+". "+transactions.get(j));
                    }
                }
            }
        }
        else System.out.println(branchName +" is not a known branch of "+name);
    }



    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }


}
