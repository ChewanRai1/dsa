public class Queues {
    int queue[];
    int size;
    int front = -1;
    int rare = -1;

    Queues(int size) {
        this.size = size;
        queue = new int[size];

    }

    void enqueue(int data) {
        if (isFull()) {
            System.out.println("queue overflow");
        } else {
            if (front == -1) {
                front = 0;
            }
            // rare++;
            queue[++rare] = data;
        }
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("queue underflow");
            return -999999;
        }
        if (front == rare) {
            int temp = front;
            front = rare = -1;
            return queue[temp];
        }
        return queue[front++];

    }

    boolean isEmpty() {
        return front == -1 && rare == -1;
    }

    boolean isFull() {
        return rare == size - 1;

    }

    public static void main(String[] args) {
        Queues q = new Queues(5);
        q.enqueue(10);
        q.enqueue(11);
        q.enqueue(87);
        System.out.println(q.dequeue());
    }

}
