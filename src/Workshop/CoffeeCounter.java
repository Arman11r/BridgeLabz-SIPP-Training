package Workshop;

import java.util.Scanner;

public class CoffeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalBill = 0;
        double gstRate = 0.18;

        while (true) {
            System.out.println("\nEnter coffee type (Espresso, Latte, Cappuccino) or type 'exit' to stop:");
            String coffeeType = sc.nextLine().toLowerCase();

            if (coffeeType.equals("exit")) {
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine(); // clear buffer

            double price = 0;

            switch (coffeeType) {
                case "espresso":
                    price = 100;
                    break;
                case "latte":
                    price = 120;
                    break;
                case "cappuccino":
                    price = 150;
                    break;
                default:
                    System.out.println("Invalid coffee type!");
                    continue;
            }

            double subtotal = price * quantity;
            double gst = subtotal * gstRate;
            double finalBill = subtotal + gst;

            System.out.println("Subtotal: ₹" + subtotal);
            System.out.println("GST (18%): ₹" + gst);
            System.out.println("Total: ₹" + finalBill);

            totalBill += finalBill;
        }

        System.out.println("\n🔔 Final Total Bill for All Customers: ₹" + totalBill);
        sc.close();
    }
}