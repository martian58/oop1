// Main class to test the ParenthesisMatching functionality
public class Main {
    public static void main(String[] args) {
        String[] tests = {
            "((a+b)-(c+d))", // Correct
            "a+(b+(c+d))",   // Correct
            "((a+b)+c",      // Incorrect
            "((a+b)+c))",    // Incorrect
            ")a+b("          // Incorrect
        };

        for (String test : tests) {
            ParenthesisMatching pm = new ParenthesisMatching(test);
            System.out.println("Input: " + test);
            System.out.println("Balanced: " + pm.parse());
            System.out.println("Stack State: " + pm.getStack());
            System.out.println();
        }
    }
}