/**
 * Class representing a stack data structure for integers using a fixed-size array.
 * Elements are managed in LIFO (Last In, First Out) order.
 */
public class MyStack {
    
    // --------------------------
    // Question 1: Member variables
    // --------------------------
    private int[] elements;
    private int top;
    private int capacity;

    /**
     * Constructor to initialize the stack with a specific capacity.
     * @param capacity The maximum number of elements the stack can hold.
     */
    public MyStack(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
        top = -1; // Stack is initially empty
    }

    // --------------------------
    // Question 1: Setters and Getters
    // --------------------------

    /**
     * Returns the array of stack elements.
     * @return The array of elements.
     */
    public int[] getElements() {
        return elements;
    }

    /**
     * Returns the current top index of the stack.
     * @return The top index.
     */
    public int getTop() {
        return top;
    }

    /**
     * Returns the capacity of the stack.
     * @return The stack's capacity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the capacity of the stack and reinitializes the array.
     * WARNING: This will reset the stack.
     * @param capacity The new capacity.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
        top = -1;
    }

    // --------------------------
    // Question 2: Push method
    // --------------------------

    /**
     * Pushes an element on top of the stack.
     * @param element The integer to be added.
     * @throws IllegalStateException If the stack is full.
     */
    public void push(int element) {
        if (top >= capacity - 1) {
            throw new IllegalStateException("Stack Overflow: Cannot push, the stack is full.");
        }
        elements[++top] = element;
    }

    // --------------------------
    // Question 3: Peek method
    // --------------------------

    /**
     * Returns the element at the top of the stack without removing it.
     * @return The top element.
     * @throws IllegalStateException If the stack is empty.
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow: Cannot peek, the stack is empty.");
        }
        return elements[top];
    }

    // --------------------------
    // Question 4: Pop method
    // --------------------------

    /**
     * Removes and returns the top element of the stack.
     * @return The removed top element.
     * @throws IllegalStateException If the stack is empty.
     */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow: Cannot pop, the stack is empty.");
        }
        return elements[top--];
    }

    // --------------------------
    // Question 5: isEmpty method
    // --------------------------

    /**
     * Checks whether the stack is empty.
     * @return True if the stack is empty, otherwise false.
     */
    public boolean isEmpty() {
        return top == -1;
    }
}
