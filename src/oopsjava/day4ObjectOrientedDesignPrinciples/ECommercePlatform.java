package oopsjava.day4ObjectOrientedDesignPrinciples;

import java.util.ArrayList;

class Product {
    String productName;
    double price;

    Product(String name, double price) {
        this.productName = name;
        this.price = price;
    }

    void showProduct() {
        System.out.println(productName + " - ₹" + price);
    }
}

class Order {
    int orderId;
    ArrayList<Product> products;

    Order(int orderId) {
        this.orderId = orderId;
        products = new ArrayList<>();
    }

    void addProduct(Product p) {
        products.add(p);
    }

    void showOrder() {
        System.out.println("Order ID: " + orderId);
        for (Product p : products) {
            p.showProduct();
        }
    }
}

class Customers {
    String name;
    ArrayList<Order> orders;

    Customers(String name) {
        this.name = name;
        orders = new ArrayList<>();
    }

    void placeOrder(Order o) {
        orders.add(o);
        System.out.println(name + " placed order ID: " + o.orderId);
    }

    void showOrders() {
        System.out.println("Orders for " + name + ":");
        for (Order o : orders) {
            o.showOrder();
        }
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Mouse", 500);
        Product p3 = new Product("Keyboard", 1500);

        Order o1 = new Order(101);
        o1.addProduct(p1);
        o1.addProduct(p2);

        Order o2 = new Order(102);
        o2.addProduct(p3);

        Customers c1 = new Customers("Arman");
        c1.placeOrder(o1);
        c1.placeOrder(o2);

        c1.showOrders();
    }
}