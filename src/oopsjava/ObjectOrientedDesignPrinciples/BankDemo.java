package oopsjava.ObjectOrientedDesignPrinciples;

import java.util.ArrayList;


class Bank {
    private String bankName;
    private ArrayList<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        customers = new ArrayList<>();
    }

    public void openAccount(Customer c, double initialBalance) {
        c.setBank(this);
        c.setBalance(initialBalance);
        customers.add(c);
        System.out.println("Account opened for " + c.getName() + " at " + bankName + " with ₹" + initialBalance);
    }

    public String getBankName() {
        return bankName;
    }
}


class Customer {
    private String name;
    private double balance;
    private Bank bank;

    public Customer(String name) {
        this.name = name;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }

    public void viewBalance() {
        System.out.println(name + " has ₹" + balance + " in " + bank.getBankName());
    }

    public String getName() {
        return name;
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Bank bank1 = new Bank("HDFC");
        Bank bank2 = new Bank("SBI");

        Customer c1 = new Customer("Arman");
        Customer c2 = new Customer("Priya");

        bank1.openAccount(c1, 10000);
        bank2.openAccount(c2, 15000);

        c1.viewBalance();
        c2.viewBalance();
    }
}