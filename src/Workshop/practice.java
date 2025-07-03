package Workshop;

public class practice {
    public static void main(String args[]) {
        Node head = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(7);
        Node node5 = new Node(8);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        
    
        
        
        
       head = sol(head);

        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static Node sol(Node head) {
    
//        if (head != null) {
//            head = head.next;
//        }
    	
    	Node current = head;
    	
    	while(current.next.next != null){
    		current  = current.next;
    				
    	}
    	current.next = null;	
    	
        return head;
    }
}









