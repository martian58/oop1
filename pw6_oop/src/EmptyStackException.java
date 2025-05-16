// Exercise 1.3: Exception for empty stack operations
public class EmptyStackException extends Exception {
    public EmptyStackException(String message) {
        super(message);
    }
}