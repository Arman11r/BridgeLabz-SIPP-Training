package oopsjava.day2ConstructorsInstancevsClassAccesModifiers;

public class LibraryBook {
    String title;
    String author;
    double price;
    boolean isAvailable;

    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is currently not available.");
        }
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: ₹" + price + ", Available: " + isAvailable);
    }

    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("The Alchemist", "Paulo Coelho", 350);
        book.display();
        book.borrowBook();
        book.display();
        book.borrowBook();
    }
}