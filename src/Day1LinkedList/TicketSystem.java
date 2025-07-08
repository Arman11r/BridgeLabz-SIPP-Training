package Day1LinkedList;

import java.util.*;

class Ticket {
    String ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(String ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketSystem {
    Ticket head = null;

    public void addTicket(Ticket ticket) {
        if (head == null) {
            head = ticket;
            ticket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = ticket;
            ticket.next = head;
        }
    }

    public void removeTicket(String ticketId) {
        if (head == null) return;
        Ticket temp = head, prev = null;

        do {
            if (temp.ticketId.equals(ticketId)) {
                if (temp == head && temp.next == head) {
                    head = null;
                } else {
                    if (temp == head) {
                        Ticket last = head;
                        while (last.next != head) last = last.next;
                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = temp.next;
                    }
                }
                System.out.println("Ticket removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println(temp.ticketId + " | " + temp.customerName + " | " + temp.movieName + " | " + temp.seatNumber + " | " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String keyword) {
        if (head == null) return;
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println(temp.ticketId + " | " + temp.customerName + " | " + temp.movieName + " | " + temp.seatNumber + " | " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No matching ticket.");
    }

    public void countTickets() {
        if (head == null) {
            System.out.println("Total tickets: 0");
            return;
        }
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total tickets: " + count);
    }

    public static void main(String[] args) {
        TicketSystem ts = new TicketSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.Remove 3.Display 4.Search 5.Count 6.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("ID Name Movie Seat Time: ");
                    ts.addTicket(new Ticket(sc.next(), sc.next(), sc.next(), sc.next(), sc.next()));
                    break;
                case 2:
                    System.out.print("Ticket ID: ");
                    ts.removeTicket(sc.next());
                    break;
                case 3:
                    ts.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer or Movie Name: ");
                    ts.searchTicket(sc.next());
                    break;
                case 5:
                    ts.countTickets();
                    break;
                case 6:
                    return;
            }
        }
    }
}