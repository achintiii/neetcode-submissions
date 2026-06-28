class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
            
        }
        
        stack.push(val);
        
        
    }
    
    public void pop() {
        if (stack.peek().equals(minStack.peek())){
            stack.pop();
            minStack.pop();
        }
        else {
            stack.pop();
        }

    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
