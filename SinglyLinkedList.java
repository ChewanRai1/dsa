public class SinglyLinkedList {
    private Node head;
    private Node tail;
    // SIZE WILL BE A LITTLE HELPFUL DURING INSERTIONS
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public void insertAtFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        this.head = node;

        // this means it is the first node in the list
        if (tail == null) {
            this.tail = head;
        }
        size++;
    }

    public void insertAtLast(int data) {

        // creating the required NODE first
        Node node = new Node(data);

        // IF WE ARE USING A TAIL, WE CAN INSERT IT AT LAST IN CONSTANT TIME
        if (tail == null) {
            insertAtFirst(data);
            return;
        }

        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int position, int data) {
        if (position == 1) {
            insertAtFirst(data);
            size++;
            return;
        } else if (position == size) {
            insertAtLast(data);
            size++;
            return;
        }

        Node node = new Node(data);

        Node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        // STORING THE NEXT OF THE CURRENT TEMP AS THAT LINK WILL BE BROKEN
        // Node nextNode = temp.next;
        // temp.next = node;
        // node.next = nextNode;

        // ALTERNATIVELY WE CAN HAVE A CONSTRUCTOR THAT TAKES IN BOTH DATA AND THE NEXT
        // NODE
        temp.next = new Node(data, temp.next);
        size++;

    }

    public int getData(int position) {
        if (position == 1) {
            return head.data;
        } else if (position == size) {
            return tail.data;
        }
        Node temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void deleteNode(int position) {
        if (position == 1) {
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    private static class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtFirst(20);
        sll.insertAtLast(30);
        sll.insertAtLast(40);
        sll.printList();

        sll.insertAtFirst(10);
        sll.printList();

        sll.insert(3, 25);

        sll.printList();

        System.out.println("The element at position 3 is " + sll.getData(3));

        sll.deleteNode(1);
        sll.printList();

        System.out.println("The element at position 4 is " + sll.getData(4));

    }
}