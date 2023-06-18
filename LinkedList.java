public class LinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    public static Node head = null;

    void insert(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newnode;
        }
    }

    public static void main(String[] args) {
        LinkedList i = new LinkedList();
        System.out.println(i);

    }

}
