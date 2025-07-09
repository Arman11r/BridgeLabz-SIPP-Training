package Day2StackQueueHashMapAndHash;

class Node {
    String key;
    int value;
    Node next;

    Node(String key, int value) {
        this.key = key;
        this.value = value;
    }
}

class CustomHashMap {
    private final int SIZE = 16;
    private Node[] table = new Node[SIZE];

    private int hash(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(String key, int value) {
        int index = hash(key);
        Node head = table[index];
        Node current = head;

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        table[index] = newNode;
    }

    public Integer get(String key) {
        int index = hash(key);
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key))
                return current.value;
            current = current.next;
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        Node current = table[index], prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null)
                    table[index] = current.next;
                else
                    prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}

public class CustomHashMapTest {
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("mango", 30);

        System.out.println(map.get("banana")); // 20
        map.remove("banana");
        System.out.println(map.get("banana")); // null
    }
}