package oopsjava.day1javaclassandmethods;

public class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addItem(int qty) {
        if (qty > 0) quantity += qty;
    }

    public void removeItem(int qty) {
        if (qty > 0 && quantity >= qty) quantity -= qty;
    }

    public double getTotalCost() {
        return quantity * price;
    }

    public void displayItem() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Unit Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + getTotalCost());
    }
}