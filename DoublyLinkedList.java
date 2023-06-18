public class DoublyLinkedList {
    public static class Node {
        Node next;

        Node prev;

        int data;

        Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    void insert(int data) {
        size++;
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
