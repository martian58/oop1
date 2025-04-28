/*
 * Question 1
 *
 *    What is the only difference in the method String asString() in your classes?
 *
Answer:
   The only difference is the operator symbol used (+ for Sum, * for Product). Everything else is the same.
 */


/*
 * 1c. What can you say about toString()?
 *
 * Answer:
 *  Since toString() is often meant to give a string representation of an object, it's natural and 
 *  appropriate to make it return the result of asString() in our classes.
 *  This way, when we call toString() on an instance of either class, we get the same output as
 *  asString(), which is a string representation of the arithmetic expression.
 */

 public class Sum implements ArithmeticExpression {
    private final ArithmeticExpression left, right;

    public Sum(ArithmeticExpression left, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    // Added label method to return the operator symbol
    private String label() {
        return "+";
    }

    @Override
    public double asValue() {
        return left.asValue() + right.asValue();
    }

    // Updated the asString() method to use the label() method
    @Override
    public String asString() {
        return "(" + left.asString() + label() + right.asString() + ")";
    }

    // Overrided toString() to return the result of asString()
    @Override
    public String toString() {
        return asString();
    }
}

