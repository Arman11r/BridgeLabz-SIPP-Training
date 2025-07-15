package Workshop;
import java.util.*;

public class SocialMediaNotificationFeed {
    static Scanner sc = new Scanner(System.in);

    abstract static class Notification {
        protected String post;
        public Notification(String post) {
            this.post = post;
        }
        public abstract String getFormattedMessage();
    }

    static class LikeNotification extends Notification {
        public LikeNotification(String post) {
            super(post);
        }

        public String getFormattedMessage() {
            return "You liked the post: \"" + post + "\"";
        }
    }

    static class CommentNotification extends Notification {
        private String comment;
        public CommentNotification(String post, String comment) {
            super(post);
            this.comment = comment;
        }

        public String getFormattedMessage() {
            return "You commented on \"" + post + "\": " + comment;
        }
    }

    static class PostNode {
        String post;
        PostNode next;

        public PostNode(String post) {
            this.post = post;
            this.next = null;
        }
    }

    private PostNode head;
    private List<Notification> notifications = new ArrayList<>();

    public void addPost(String content) {
        PostNode newNode = new PostNode(content);
        if (head == null) {
            head = newNode;
        } else {
            PostNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    public void displayPosts() {
        if (head == null) {
            System.out.println("No posts yet.");
            return;
        }

        System.out.println("Posts (Most Recent First):");
        List<String> posts = new ArrayList<>();
        PostNode temp = head;

        while (temp != null) {
            posts.add(temp.post);
            temp = temp.next;
        }

        int index = posts.size();
        for (int i = posts.size() - 1; i >= 0; i--) {
            System.out.println(index + ". " + posts.get(i));
            index--;
        }
    }
    public void likePost(int index) {
        String selected = getPostByIndex(index);
        if (selected != null) {
            notifications.add(new LikeNotification(selected));
            System.out.println("Post liked.");
        }
    }

    public void commentPost(int index, String comment) {
        String selected = getPostByIndex(index);
        if (selected != null) {
            notifications.add(new CommentNotification(selected, comment));
            System.out.println("Comment added.");
        }
    }

    private String getPostByIndex(int index) {
        PostNode temp = head;
        int count = 1;
        while (temp != null) {
            if (count == index) return temp.post;
            temp = temp.next;
            count++;
        }
        System.out.println("Invalid post number.");
        return null;
    }

    public void displayNotifications() {
        if (notifications.isEmpty()) {
            System.out.println("No interactions yet.");
            return;
        }
        System.out.println("Notifications:");
        for (Notification n : notifications) {
            System.out.println(n.getFormattedMessage());
        }
    }

    public static void main(String[] args) {
        SocialMediaNotificationFeed feed = new SocialMediaNotificationFeed();

        System.out.println("Create Posts");
        while (true) {
            System.out.print("Enter Post: ");
            String post = sc.nextLine();
            feed.addPost(post);

            String again;
            while (true) {
                System.out.print("Add another post? (Y/N): ");
                again = sc.nextLine();
                if (again.equalsIgnoreCase("Y") || again.equalsIgnoreCase("N")) {
                    break; 
                } else {
                    System.out.println("Invalid input. Please enter Y or N.");
                }
            }

            if (again.equalsIgnoreCase("N")) break;
        }

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. View Posts");
            System.out.println("2. Like a Post");
            System.out.println("3. Comment on a Post");
            System.out.println("4. View My Notifications");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    feed.displayPosts();
                    break;
                case 2:
                    feed.displayPosts();
                    System.out.print("Enter post number to like: ");
                    int likeIndex = Integer.parseInt(sc.nextLine());
                    feed.likePost(likeIndex);
                    break;
                case 3:
                    feed.displayPosts();
                    System.out.print("Enter post number to comment on: ");
                    int commentIndex = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter your comment: ");
                    String comment = sc.nextLine();
                    feed.commentPost(commentIndex, comment);
                    break;
                case 4:
                    feed.displayNotifications();
                    break;
                case 5:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}