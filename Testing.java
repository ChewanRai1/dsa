public class Testing {
    char stk[];
    int top = -1;
    int size;

    Testing(int i) {
        this.size = i;
        stk = new char[i];
    }

    public void push(int expchar) {
        if (isFull()) {
            System.out.println("stack overflow");

        } else {
            top++;
            stk[top] = (char) expchar;
        }
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("stack underflow");
            return 'f';
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
    char peek() {
        return stk[top];
    }

    // public class Testing {
    public boolean checkparenthesis(String exp) {
        Testing tst = new Testing(exp.length());
        String openbracket = "[{(";
        String closebracket = "]})";

        for (int i = 0; i < exp.length(); i++) {
            int expchar = exp.charAt(i);
            if (openbracket.indexOf(expchar) != -1) {
                tst.push(expchar);
            } else {
                int index = closebracket.indexOf(expchar);
                char crossopenbracket = openbracket.charAt(index);
                if (tst.isEmpty()) {
                    return false;
                }
                if (tst.pop() != crossopenbracket) {
                    return false;
                }
            }
        }
        if (!tst.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Testing t = new Testing(0);
        System.out.println(t.checkparenthesis("()"));
    }
}
