package Day1LinkedList;

import java.util.*;

class User {
    String userId;
    String name;
    int age;
    List<String> friends;
    User next;

    User(String userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMediaManager {
    User head = null;

    public void addUser(User u) {
        u.next = head;
        head = u;
    }

    public User getUser(String userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId.equals(userId)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(String u1, String u2) {
        User user1 = getUser(u1);
        User user2 = getUser(u2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (!user1.friends.contains(u2)) user1.friends.add(u2);
        if (!user2.friends.contains(u1)) user2.friends.add(u1);
        System.out.println("Friend connection added.");
    }

    public void removeFriend(String u1, String u2) {
        User user1 = getUser(u1);
        User user2 = getUser(u2);
        if (user1 != null && user2 != null) {
            user1.friends.remove(u2);
            user2.friends.remove(u1);
            System.out.println("Friend connection removed.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void displayFriends(String userId) {
        User user = getUser(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + user.name + ": " + user.friends);
    }

    public void mutualFriends(String u1, String u2) {
        User user1 = getUser(u1);
        User user2 = getUser(u2);
        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }
        List<String> mutual = new ArrayList<>(user1.friends);
        mutual.retainAll(user2.friends);
        System.out.println("Mutual friends: " + mutual);
    }

    public void searchUser(String query) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(query) || temp.userId.equalsIgnoreCase(query)) {
                System.out.println("Found: " + temp.name + " (" + temp.userId + "), Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friends.size() + " friends.");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaManager smm = new SocialMediaManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add User 2.Add Friend 3.Remove Friend 4.Display Friends 5.Mutual 6.Search 7.Count Friends 8.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("UserID, Name, Age: ");
                    smm.addUser(new User(sc.next(), sc.next(), sc.nextInt()));
                    break;
                case 2:
                    System.out.print("User1 ID and User2 ID: ");
                    smm.addFriend(sc.next(), sc.next());
                    break;
                case 3:
                    System.out.print("User1 ID and User2 ID: ");
                    smm.removeFriend(sc.next(), sc.next());
                    break;
                case 4:
                    System.out.print("UserID: ");
                    smm.displayFriends(sc.next());
                    break;
                case 5:
                    System.out.print("User1 ID and User2 ID: ");
                    smm.mutualFriends(sc.next(), sc.next());
                    break;
                case 6:
                    System.out.print("Search by Name or ID: ");
                    smm.searchUser(sc.next());
                    break;
                case 7:
                    smm.countFriends();
                    break;
                case 8:
                    return;
            }
        }
    }
}