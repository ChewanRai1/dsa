public class CircularQueue {
    int queue[];
    int size;
    int front = -1;
    int rear = -1;

    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
    }

    void enqueue(int data) {
        if (isFull()) {
            System.out.println("queuq overflow");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            queue[rear] = data;
        }
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("queue underflow");
            return -999999;
        }
        if (front == rear) {
            int temp = front;
            front = rear = -1;
            return queue[temp];
        }
        int indxfront = front;
        front = (front + 1) % size;
        return queue[indxfront];
    }

    boolean isFull() {
        return (rear + 1) % size == front;
    }

    boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public static void main(String[] args) {
        CircularQueue c = new CircularQueue(5);
        c.enqueue(10);
        c.enqueue(12);
        c.enqueue(16);
        System.out.println(c.dequeue());
    }

}
