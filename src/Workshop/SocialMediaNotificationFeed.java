package Workshop;
import java.util.*;
public class SocialMediaNotificationFeed {
	static Scanner sc = new Scanner(System.in);
   
    static class Node {
        String data;
        Node next;

        Node(String data2) {
            this.data = data2;
            this.next = null;
        }
    }

    private Node head;


    public void insert(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }
    public int getLength() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    
    public void display() {
        Node current = head;
        if (current == null) {
            System.out.println("Linked List is empty");
            return;
        }

        System.out.print("    ");
        while (current != null) {
        	
            System.out.print(current.data);
            current = current.next;
        }
        
    }

    public static void main(String[] args) {
    	
    	SocialMediaNotificationFeed list = new SocialMediaNotificationFeed();
    	
    	while(true) {
    	System.out.println("Enter Post:  ");
    	String posted = sc.nextLine();
        list.insert(posted);
        System.out.println("Another Post? (Y or N)");
        String loop = sc.nextLine();
        if(loop.equalsIgnoreCase("n")) {
        	
        	break;	
        }
      
    	}
    	
    	for(int i = list.getLength();i>0;i--){
    		 list.display();
    		
    	}
    	
      
    }
}