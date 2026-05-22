class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char temp = stack.pop();
                if (temp == '{' && c != '}') {
                    return false;
                } else if (temp == '(' && c != ')') {
                    return false;
                } else if (temp == '[' && c != ']') {
                    return false;
                }
            }
        }
        if (stack.size() == 0) {
         return true;
        } else {
            return false;
        }
    }
}
