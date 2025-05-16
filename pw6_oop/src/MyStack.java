// Exercise 1.1: Generic MyStack class
public class MyStack<E> {
    private E[] stack;
    private int top;
    private int capacity;

    // Constructor
    @SuppressWarnings("unchecked")
    public MyStack(int capacity) {
        this.capacity = capacity;
        this.stack = (E[]) new Object[capacity];
        this.top = -1;
    }

    // Exercise 1.2: Push method with MaxCapacityException
    public void push(E e) throws MaxCapacityException {
        if (top + 1 >= capacity) {
            throw new MaxCapacityException("Stack has reached maximum capacity: " + capacity);
        }
        stack[++top] = e;
    }

    // Exercise 1.3: Pop method with EmptyStackException
    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Cannot pop from an empty stack");
        }
        E element = stack[top];
        stack[top--] = null; // Clear reference
        return element;
    }

    // Exercise 1.3: Peek method with EmptyStackException
    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Cannot peek an empty stack");
        }
        return stack[top];
    }

    // Helper method to check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Exercise 1.4: Override toString to display stack details
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
            if (i < top) sb.append(", ");
        }
        sb.append("], Capacity: ").append(capacity).append(", Top: ").append(top);
        return sb.toString();
    }

    // Getters
    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return top + 1;
    }
}