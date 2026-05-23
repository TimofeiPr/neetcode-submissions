class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> stack;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (!minStack.isEmpty()) {
            minStack.push(Math.min(minStack.peek(), val));
        } else {
            minStack.push(val);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
