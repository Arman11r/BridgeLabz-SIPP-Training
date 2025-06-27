package oopsjava.day3thisStaticFinalKeywordAndInstanceOfOperators;

class Product {
    static double discount = 5.0;
    private String productName;
    private double price;
    private int quantity;
    private final String productID;

    public Product(String productName, double price, int quantity, String productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    public void displayDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID   : " + productID);
            System.out.println("Product Name : " + productName);
            System.out.println("Price        : ₹" + price);
            System.out.println("Quantity     : " + quantity);
            System.out.println("Discount     : " + discount + "%");
            System.out.println("------------------------------");
        }
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000, 1, "P101");
        Product p2 = new Product("Headphones", 2500, 2, "P102");

        if (p1 instanceof Product) {
            p1.displayDetails();
        }

        if (p2 instanceof Product) {
            p2.displayDetails();
        }

        Product.updateDiscount(10.0);

        Product p3 = new Product("Smartwatch", 4999, 1, "P103");

        if (p3 instanceof Product) {
            p3.displayDetails();
        }
    }
}