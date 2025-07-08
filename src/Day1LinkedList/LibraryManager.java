package Day1LinkedList;

import java.util.*;

class Book {
    String title, author, genre, bookId;
    boolean available;
    Book prev, next;

    Book(String title, String author, String genre, String bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
        this.prev = this.next = null;
    }
}

public class LibraryManager {
    Book head = null, tail = null;

    public void addAtBeginning(Book b) {
        if (head == null) head = tail = b;
        else {
            b.next = head;
            head.prev = b;
            head = b;
        }
    }

    public void addAtEnd(Book b) {
        if (head == null) head = tail = b;
        else {
            tail.next = b;
            b.prev = tail;
            tail = b;
        }
    }

    public void addAtPosition(Book b, int pos) {
        if (pos == 0) {
            addAtBeginning(b);
            return;
        }
        Book temp = head;
        for (int i = 0; temp != null && i < pos - 1; i++) temp = temp.next;
        if (temp == null || temp.next == null) {
            addAtEnd(b);
            return;
        }
        b.next = temp.next;
        b.prev = temp;
        temp.next.prev = b;
        temp.next = b;
    }

    public void removeById(String bookId) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId.equals(bookId)) {
                if (temp == head && temp == tail) head = tail = null;
                else if (temp == head) {
                    head = head.next;
                    head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void updateAvailability(String bookId, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId.equals(bookId)) {
                temp.available = status;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void search(String query) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
                System.out.println(temp.title + " | " + temp.author + " | " + temp.genre + " | " + temp.bookId + " | " + (temp.available ? "Available" : "Not Available"));
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No match found.");
    }

    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.author + " | " + temp.genre + " | " + temp.bookId + " | " + (temp.available ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.author + " | " + temp.genre + " | " + temp.bookId + " | " + (temp.available ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    public void countBooks() {
        Book temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total books: " + count);
    }

    public static void main(String[] args) {
        LibraryManager lm = new LibraryManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.AddBegin 2.AddEnd 3.AddPos 4.Remove 5.UpdateAvail 6.Search 7.DisplayFWD 8.DisplayREV 9.Count 10.Exit");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1: case 2: case 3:
                    System.out.print("Title Author Genre BookID Available(true/false): ");
                    String t = sc.next();
                    String a = sc.next();
                    String g = sc.next();
                    String id = sc.next();
                    boolean avail = sc.nextBoolean();
                    Book b = new Book(t, a, g, id, avail);
                    if (ch == 1) lm.addAtBeginning(b);
                    else if (ch == 2) lm.addAtEnd(b);
                    else {
                        System.out.print("Position: ");
                        lm.addAtPosition(b, sc.nextInt());
                    }
                    break;
                case 4:
                    System.out.print("Book ID to remove: ");
                    lm.removeById(sc.next());
                    break;
                case 5:
                    System.out.print("Book ID and new status: ");
                    lm.updateAvailability(sc.next(), sc.nextBoolean());
                    break;
                case 6:
                    System.out.print("Title or Author: ");
                    lm.search(sc.next());
                    break;
                case 7:
                    lm.displayForward();
                    break;
                case 8:
                    lm.displayReverse();
                    break;
                case 9:
                    lm.countBooks();
                    break;
                case 10:
                    return;
            }
        }
    }
}