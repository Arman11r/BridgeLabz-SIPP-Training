package oopsjava.day5Inheritance.HierarchialInheritance;

class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void showBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    int withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, int withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit + " per day");
    }
}

class FixedDepositAccount extends BankAccount {
    int lockInPeriod; // in months

    FixedDepositAccount(String accountNumber, double balance, int lockInPeriod) {
        super(accountNumber, balance);
        this.lockInPeriod = lockInPeriod;
    }

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Lock-in Period: " + lockInPeriod + " months");
    }
}

public class BankTest {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SAV123", 10000.0, 3.5);
        CheckingAccount ca = new CheckingAccount("CHK456", 15000.0, 5000);
        FixedDepositAccount fda = new FixedDepositAccount("FD789", 50000.0, 12);

        sa.showBalance();
        sa.displayAccountType();
        System.out.println("-----");

        ca.showBalance();
        ca.displayAccountType();
        System.out.println("-----");

        fda.showBalance();
        fda.displayAccountType();
    }
}