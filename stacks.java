public class stacks {
    int stk[];
    int top = -1;
    int size;

    stacks(int size) {
        this.size = size;
        stk = new int[size];
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("stack overflow");

        } else {
            top++;
            stk[top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack underflow");
            return -99999999;
        }
        // int temp = top;
        // top--;
        // return stk[temp]
        return stk[top--];
    }

    boolean isFull() {
        return top == size - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    // }

    // public class Testing {
    public static void main(String[] args) {
        stacks stk = new stacks(5);
        stk.push(10);
        stk.push(20);
        System.out.println(stk.pop());
    }
}