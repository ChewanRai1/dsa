import java.util.HashMap;

public class LRUCaching {
    int capacity = 0;
    HashMap<Integer, Node> map;

    public static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = this.prev = null;
        }
    }

    LRUCaching(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // remove node
            remove(map.get(key));
        } else if (map.size() == capacity) {
            // remove tail
            remove(tail);
        } else {
            Node newnode = new Node(key, value);
            insert(newnode);
        }

    }

    Node head = null;
    Node tail = null;

    public void insert(Node newnode) {
        map.put(newnode.key, newnode);
        if (head == null) {
            head = tail = newnode;
        } else {
            head.prev = newnode;
            newnode.next = head;
            head = newnode;
        }
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        // remove node
        remove(node);
        // insert node
        insert(node);
        return node.value;
    }

    public void remove(Node node) {
        map.remove(node.key);
        if (node == head) {
            Node temp = head;
            head = head.next;
            temp.next = null;
        } else if (node == tail) {
            Node temp = tail;
            tail = tail.prev;
            tail.prev = null;
            temp.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = node.prev = null;
        }
    }
}

// implements LFu caching