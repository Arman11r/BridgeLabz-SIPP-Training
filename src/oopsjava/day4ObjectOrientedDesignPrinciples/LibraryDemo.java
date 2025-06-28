package oopsjava.day4ObjectOrientedDesignPrinciples;

import java.util.ArrayList;


class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void showDetails() {
        System.out.println("Book: " + title + ", Author: " + author);
    }
}

class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public void showLibrary() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            book.showDetails();
        }
        System.out.println();
    }
}


public class LibraryDemo {
    public static void main(String[] args) {

        Book b1 = new Book("The Alchemist", "Paulo Coelho");
        Book b2 = new Book("Atomic Habits", "James Clear");
        Book b3 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki");

 
        Library lib1 = new Library("City Library");
        Library lib2 = new Library("College Library");

        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2); 
        lib2.addBook(b3);

   
        lib1.showLibrary();
        lib2.showLibrary();
    }
}