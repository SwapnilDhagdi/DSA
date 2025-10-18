/* the approach is to make 2 stack one to store all the numbers and another to store minimum numbers only or numbers which are equall to minimum or top number*/
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty()){
            minStack.push(val);
        }else if(minStack.peek()>=val){
            minStack.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.peek().equals( minStack.peek())){//you should only pop the minStack of it matches the stack
            minStack.pop();
        }
        stack.pop();
    }
    public int top() {
        
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
