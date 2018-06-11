class MinStack {

    /** initialize your data structure here. */
    public Stack<Integer> stackData;
    public Stack<Integer> stackMin;
    
    public MinStack() {
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }
    
    public void push(int x) {
        stackData.push(x);
        if (stackMin.isEmpty()) {
            stackMin.push(x);
        } else{
            if (stackMin.peek() >= x) {
                stackMin.push(x);
            }
        }
    }
    
    public void pop() {
        int top = stackData.pop();
        if (top == stackMin.peek()) {
            stackMin.pop();
        }
    }
    
    public int top() {
        return stackData.peek();
    }
    
    public int getMin() {
        return stackMin.peek();
    }
}