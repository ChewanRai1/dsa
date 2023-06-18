public class InfixToPostFix {
    public int precedence(char c) {
        // if(c=='+' || c=='-'){
        // return 1;
        // }
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public String infixtopostfixConversion(String exp) {
        String postfix = "";
        Testing stk = new Testing(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix = postfix + c;
            } else {
                if (c == '(') {
                    stk.push(c);
                } else if (c == ')') {
                    while (!stk.isEmpty() && stk.peek() != '(') {
                        postfix = postfix + stk.pop();
                    }
                    stk.pop();
                } else {
                    while (!stk.isEmpty() && precedence(c) <= precedence(stk.peek())) {
                        postfix = postfix + stk.pop();
                    }
                    stk.push(c);
                }
            }
        }
        while (stk.isEmpty() == false) {
            postfix = postfix + stk.pop();
        }
        return postfix;

    }

    public static void main(String[] args) {
        InfixToPostFix ab = new InfixToPostFix();
        System.out.println(ab.infixtopostfixConversion("5+2+(3*5)"));

    }
}
