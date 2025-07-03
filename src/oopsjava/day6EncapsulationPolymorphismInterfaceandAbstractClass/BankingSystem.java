package oopsjava.day6EncapsulationPolymorphismInterfaceandAbstractClass;

import java.util.*;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    public void applyForLoan(double amount) {
        System.out.println("Loan applied for ₹" + amount + " from Savings Account.");
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 10000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.02;
    }

    public void applyForLoan(double amount) {
        System.out.println("Loan applied for ₹" + amount + " from Current Account.");
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 20000;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SB123", "Arman", 15000));
        accounts.add(new CurrentAccount("CA456", "Riya", 50000));

        for (BankAccount acc : accounts) {
            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Balance: ₹" + acc.getBalance());
            System.out.println("Interest: ₹" + acc.calculateInterest());
            if (acc instanceof Loanable) {
                Loanable l = (Loanable) acc;
                l.applyForLoan(20000);
                System.out.println("Loan Eligible: " + l.calculateLoanEligibility());
            }
            System.out.println("---------------------------");
        }
    }
}
