package VenoBank;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    private Customer findCustomer(String customerName){
        for (int i = 0; i < customers.size(); i++) {
            Customer foundCustomer = customers.get(i);
            if (customerName.equals(foundCustomer.getName())){
                return foundCustomer;
            }
        }
        return null;
    }

    public boolean addCustomer(String name, double initialAmount){
        if(findCustomer(name) == null){
            customers.add(new Customer(name,initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String name, double amount){
        Customer customer = findCustomer(name);
        if(customer != null){
            customer.addTransaction(amount);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
