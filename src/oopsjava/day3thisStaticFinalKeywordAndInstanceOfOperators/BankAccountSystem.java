package oopsjava.day3thisStaticFinalKeywordAndInstanceOfOperators;

class BankAccount {
   
    static String bankName = "BrightBank";


    private static int totalAccounts = 0;


    private String accountHolderName;
    private final int accountNumber; 
    private double balance;

   
    public BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name     : " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account No.   : " + accountNumber);
            System.out.println("Balance       : ₹" + balance);
            System.out.println("----------------------------------");
        } else {
            System.out.println("Not a valid BankAccount instance.");
        }
    }

    public static void getTotalAccounts() {
        System.out.println("Total Bank Accounts Created: " + totalAccounts);
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Arman Ahmed", 1001, 5000.0);
        BankAccount acc2 = new BankAccount("Priya Sharma", 1002, 10000.0);

       
        if (acc1 instanceof BankAccount) {
            acc1.displayDetails();
        }

        if (acc2 instanceof BankAccount) {
            acc2.displayDetails();
        }

        // Static method call
        BankAccount.getTotalAccounts();
    }
}