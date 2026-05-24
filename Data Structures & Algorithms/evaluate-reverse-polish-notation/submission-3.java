class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i ++) {
            char charAt = tokens[i].charAt(0);
            if (tokens[i].length() == 1) {
                if (charAt == '+') {
                    stack.push(stack.pop() + stack.pop());
                } else if (charAt == '-') {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                } else if (charAt == '/') {
                    int a = stack.pop();
                    System.out.print(a);
                    int b = stack.pop();
                    stack.push(b / a);
                } else if (charAt == '*') {
                    stack.push(stack.pop() * stack.pop());
                } else {
                    stack.push(Character.getNumericValue(charAt));
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
