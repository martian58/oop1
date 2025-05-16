// Exercise 2: ParenthesisMatching class
public class ParenthesisMatching {
    private MyStack<Character> stack; // Stack to store parentheses
    private String input; // String to parse

    // Exercise 3: Constructor
    public ParenthesisMatching(String input) {
        this.input = input;
        this.stack = new MyStack<>(input.length()); // Stack capacity equals input length
    }

    // Getters and setters
    public MyStack<Character> getStack() {
        return stack;
    }

    public void setStack(MyStack<Character> stack) {
        this.stack = stack;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
        this.stack = new MyStack<>(input.length()); // Update stack capacity
    }

    // Exercise 4: Static method to check matching parentheses
    public static boolean bracketsAreMatching(char c1, char c2) {
        return c1 == '(' && c2 == ')';
    }

    // Exercise 5: Parse method to check if parentheses are balanced
    public boolean parse() {
        try {
            for (char c : input.toCharArray()) {
                if (c == '(') {
                    stack.push(c); // Push opening parenthesis
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        return false; // Extra closing parenthesis
                    }
                    char top = stack.pop(); // Pop last opening parenthesis
                    if (!bracketsAreMatching(top, c)) {
                        return false; // Mismatched parentheses
                    }
                }
            }
            return stack.isEmpty(); // True if all parentheses matched
        } catch (MaxCapacityException | EmptyStackException e) {
            return false; // Handle unexpected stack errors
        }
    }
}