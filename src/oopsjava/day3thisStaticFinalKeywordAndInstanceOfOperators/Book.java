package oopsjava.day3thisStaticFinalKeywordAndInstanceOfOperators;

public class Book {
    static String libraryName = "Central City Library";
    private String title;
    private String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Library Name: " + libraryName);
            System.out.println("Title       : " + title);
            System.out.println("Author      : " + author);
            System.out.println("ISBN        : " + isbn);
            System.out.println("-----------------------------");
        }
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
}

class LibraryManagementSystem {
    public static void main(String[] args) {
        Book b1 = new Book("Atomic Habits", "James Clear", "978-0735211292");
        Book b2 = new Book("The Alchemist", "Paulo Coelho", "978-0061122415");

        if (b1 instanceof Book) {
            b1.displayDetails();
        }

        if (b2 instanceof Book) {
            b2.displayDetails();
        }

        Book.displayLibraryName();
    }
}
