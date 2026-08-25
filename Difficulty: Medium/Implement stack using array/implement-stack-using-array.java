class myStack {
    int size;
    int[] stack;
    int top;
    public myStack(int n) {
        size = n;
        stack = new int[n];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1; // means stack empty h
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int x) {
        if(!isFull())
        stack[++top] = x;
    }

    public void pop() {
        if(!isEmpty())
            top--;
    }

    public int peek() {
        if(!isEmpty())
        return stack[top];
        
        return -1;
    }
}