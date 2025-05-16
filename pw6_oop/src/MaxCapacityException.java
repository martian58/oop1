// Exercise 1.2: Exception for stack overflow
public class MaxCapacityException extends Exception {
    public MaxCapacityException(String message) {
        super(message);
    }
}