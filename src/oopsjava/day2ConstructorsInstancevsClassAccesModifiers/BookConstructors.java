package oopsjava.day2ConstructorsInstancevsClassAccesModifiers;

public class BookConstructors {
    String title;
    String author;
    double price;

    public BookConstructors() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    public BookConstructors(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price);
    }

    public static void main(String[] args) {
    	BookConstructors book1 = new BookConstructors();
    	BookConstructors book2 = new BookConstructors("Java", "James", 599.99);
        book1.display();
        book2.display();
    }
}