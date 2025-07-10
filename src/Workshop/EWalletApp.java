package Workshop;

import java.util.*;

interface Transferable {
    void transferTo(User receiver, double amount);
}

abstract class Wallet implements Transferable {
    protected final int accountNo;
    private double balance;

    public Wallet(int accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    protected void addMoney(double amount) {
        this.balance += amount;
    }

    protected boolean deductMoney(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public int getAccountNo() {
        return accountNo;
    }
}

class PersonalWallet extends Wallet {
    public PersonalWallet(int accountNo, double balance) {
        super(accountNo, balance);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        if (amount > 10000) {
            System.out.println("Personal wallet transfer limit is ₹10000");
            return;
        }
        double tax = amount * 0.02;
        double total = amount + tax;
        if (deductMoney(total)) {
            receiver.getWallet().addMoney(amount);
            EWalletApp.logTransaction(accountNo, receiver.getWallet().getAccountNo(), amount);
            System.out.println("Transferred ₹" + amount + " with ₹" + tax + " tax.");
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

class BusinessWallet extends Wallet {
    public BusinessWallet(int accountNo, double balance) {
        super(accountNo, balance);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        if (amount > 50000) {
            System.out.println("Business wallet transfer limit is ₹50000");
            return;
        }
        double tax = amount * 0.01;
        double total = amount + tax;
        if (deductMoney(total)) {
            receiver.getWallet().addMoney(amount);
            EWalletApp.logTransaction(accountNo, receiver.getWallet().getAccountNo(), amount);
            System.out.println("Transferred ₹" + amount + " with ₹" + tax + " tax.");
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

class User {
    private final String name;
    private final Wallet wallet;

    public User(String name, Wallet wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getName() {
        return name;
    }
}

public class EWalletApp {
    private static final Scanner sc = new Scanner(System.in);
    private static final Map<Integer, User> userMap = new HashMap<>();
    private static final List<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("\nWelcome to E-Wallet Application :)\n");
        while (true) {
            System.out.println("==============================================");
            System.out.println("1. Register Me");
            System.out.println("2. Load Money");
            System.out.println("3. Transfer Funds");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.println("==============================================");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> loadMoney();
                case 3 -> transferFunds();
                case 4 -> showTransactionHistory();
                case 5 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private static void registerUser() {
        System.out.print("Enter your name: ");
        String name = sc.next();
        System.out.print("Enter account number: ");
        int acc = sc.nextInt();
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Choose wallet type (1. Personal 2. Business): ");
        int type = sc.nextInt();

        Wallet wallet = (type == 2) ? new BusinessWallet(acc, balance) : new PersonalWallet(acc, balance);
        User user = new User(name, wallet);
        userMap.put(acc, user);
        System.out.println("\n User Registered Successfully!");
    }

    private static void loadMoney() {
        System.out.print("Enter your account number: ");
        int acc = sc.nextInt();
        User user = userMap.get(acc);
        if (user == null) {
            System.out.println(" Account not found.");
            return;
        }
        System.out.print("Enter amount to load: ");
        double amt = sc.nextDouble();
        user.getWallet().addMoney(amt);
        System.out.println("Amount ₹" + amt + " added. New Balance: ₹" + user.getWallet().getBalance());
    }

    private static void transferFunds() {
        System.out.print("Enter your (Sender) account number: ");
        int senderAcc = sc.nextInt();
        User sender = userMap.get(senderAcc);
        if (sender == null) {
            System.out.println("Sender account not found.");
            return;
        }

        System.out.print("Enter Receiver's account number: ");
        int receiverAcc = sc.nextInt();
        User receiver = userMap.get(receiverAcc);
        if (receiver == null) {
            System.out.println("Receiver account not found.");
            return;
        }

        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();

        sender.getWallet().transferTo(receiver, amount);
    }

    public static void logTransaction(int sender, int receiver, double amount) {
        transactionHistory.add("Sender Account No : " + sender + " | Receiver Account No : " + receiver + " | Amount: ₹" + amount);
    }

    private static void showTransactionHistory() {
        System.out.println("=-=-=-=-=-=-= TRANSACTION HISTORY =-=-=-=-=-=-=-=");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String record : transactionHistory) {
                System.out.println(record);
                System.out.println();
            }
        }
    }
}