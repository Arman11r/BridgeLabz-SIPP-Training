package Day1LinkedList;

import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next, prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = this.prev = null;
    }
}

public class MovieManager {
    Movie head = null, tail = null;

    // Add at beginning
    public void addAtBeginning(Movie m) {
        if (head == null) {
            head = tail = m;
        } else {
            m.next = head;
            head.prev = m;
            head = m;
        }
    }

    // Add at end
    public void addAtEnd(Movie m) {
        if (head == null) {
            head = tail = m;
        } else {
            tail.next = m;
            m.prev = tail;
            tail = m;
        }
    }

    // Add at specific position
    public void addAtPosition(Movie m, int pos) {
        if (pos == 0) {
            addAtBeginning(m);
            return;
        }

        Movie temp = head;
        for (int i = 0; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(m);
            return;
        }

        m.next = temp.next;
        m.prev = temp;
        temp.next.prev = m;
        temp.next = m;
    }

    // Remove by title
    public void removeByTitle(String title) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Movie removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Search by director or rating
    public void searchByDirectorOrRating(String director, Double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if ((director != null && temp.director.equalsIgnoreCase(director)) ||
                (rating != null && temp.rating == rating)) {
                System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No matching movies found.");
    }

    // Update rating
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Display forward
    public void displayForward() {
        Movie temp = head;
        if (temp == null) {
            System.out.println("No movies.");
            return;
        }
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        Movie temp = tail;
        if (temp == null) {
            System.out.println("No movies.");
            return;
        }
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        MovieManager manager = new MovieManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Begin 2.Add End 3.Add Pos 4.Remove 5.Search 6.Update Rating 7.Display FWD 8.Display REV 9.Exit");
            int ch = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (ch) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    String t = sc.nextLine();
                    String d = sc.nextLine();
                    int y = sc.nextInt();
                    double r = sc.nextDouble();
                    Movie m = new Movie(t, d, y, r);
                    if (ch == 1) manager.addAtBeginning(m);
                    else if (ch == 2) manager.addAtEnd(m);
                    else {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        manager.addAtPosition(m, pos);
                    }
                    break;

                case 4:
                    System.out.print("Enter Title to remove: ");
                    String removeTitle = sc.nextLine();
                    manager.removeByTitle(removeTitle);
                    break;

                case 5:
                    System.out.print("Search by Director (leave blank if not): ");
                    String dir = sc.nextLine();
                    System.out.print("Search by Rating (enter -1 if not): ");
                    double rating = sc.nextDouble();
                    manager.searchByDirectorOrRating(dir.isEmpty() ? null : dir, rating < 0 ? null : rating);
                    break;

                case 6:
                    System.out.print("Enter Title and New Rating: ");
                    String title = sc.nextLine();
                    double newR = sc.nextDouble();
                    manager.updateRating(title, newR);
                    break;

                case 7:
                    manager.displayForward();
                    break;

                case 8:
                    manager.displayReverse();
                    break;

                case 9:
                    System.exit(0);
            }
        }
    }
}