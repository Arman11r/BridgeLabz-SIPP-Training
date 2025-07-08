package Day1LinkedList;

import java.util.*;

class Item {
    String itemName;
    String itemId;
    int quantity;
    double price;
    Item next;

    Item(String itemName, String itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManager {
    Item head = null;

    public void addItemAtBeginning(Item item) {
        item.next = head;
        head = item;
    }

    public void addItemAtEnd(Item item) {
        if (head == null) {
            head = item;
        } else {
            Item temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = item;
        }
    }

    public void addItemAtPosition(Item item, int pos) {
        if (pos == 0) {
            addItemAtBeginning(item);
            return;
        }
        Item temp = head;
        for (int i = 0; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }
        item.next = temp.next;
        temp.next = item;
    }

    public void removeItem(String id) {
        if (head == null) return;
        if (head.itemId.equals(id)) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && !temp.next.itemId.equals(id)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Item not found.");
        }
    }

    public void updateQuantity(String id, int qty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId.equals(id)) {
                temp.quantity = qty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByIdOrName(String query) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemId.equals(query) || temp.itemName.equalsIgnoreCase(query)) {
                System.out.println(temp.itemName + " | " + temp.itemId + " | Qty: " + temp.quantity + " | Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    public void calculateTotalValue() {
        Item temp = head;
        double total = 0;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    public void sortByNameOrPrice(boolean byName, boolean ascending) {
        head = mergeSort(head, byName, ascending);
    }

    private Item mergeSort(Item head, boolean byName, boolean asc) {
        if (head == null || head.next == null) return head;

        Item mid = getMid(head);
        Item right = mid.next;
        mid.next = null;

        Item leftSorted = mergeSort(head, byName, asc);
        Item rightSorted = mergeSort(right, byName, asc);

        return merge(leftSorted, rightSorted, byName, asc);
    }

    private Item merge(Item a, Item b, boolean byName, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (byName) {
            condition = asc ? a.itemName.compareTo(b.itemName) <= 0 : a.itemName.compareTo(b.itemName) >= 0;
        } else {
            condition = asc ? a.price <= b.price : a.price >= b.price;
        }

        if (condition) {
            a.next = merge(a.next, b, byName, asc);
            return a;
        } else {
            b.next = merge(a, b.next, byName, asc);
            return b;
        }
    }

    private Item getMid(Item head) {
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayAll() {
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.itemName + " | " + temp.itemId + " | Qty: " + temp.quantity + " | Price: " + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryManager inv = new InventoryManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.AddBegin 2.AddEnd 3.AddPos 4.Remove 5.UpdateQty 6.Search 7.TotalValue 8.Sort 9.Display 10.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: case 2: case 3:
                    System.out.print("Enter Name, ID, Qty, Price: ");
                    String name = sc.next();
                    String id = sc.next();
                    int qty = sc.nextInt();
                    double price = sc.nextDouble();
                    Item item = new Item(name, id, qty, price);
                    if (ch == 1) inv.addItemAtBeginning(item);
                    else if (ch == 2) inv.addItemAtEnd(item);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        inv.addItemAtPosition(item, pos);
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to remove: ");
                    inv.removeItem(sc.next());
                    break;
                case 5:
                    System.out.print("Enter ID and new Quantity: ");
                    inv.updateQuantity(sc.next(), sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter ID or Name: ");
                    inv.searchByIdOrName(sc.next());
                    break;
                case 7:
                    inv.calculateTotalValue();
                    break;
                case 8:
                    System.out.print("Sort by (1=Name, 2=Price): ");
                    boolean byName = sc.nextInt() == 1;
                    System.out.print("Ascending? (1=yes, 0=no): ");
                    boolean asc = sc.nextInt() == 1;
                    inv.sortByNameOrPrice(byName, asc);
                    break;
                case 9:
                    inv.displayAll();
                    break;
                case 10:
                    System.exit(0);
            }
        }
    }
}