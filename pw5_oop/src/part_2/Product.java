public class Product implements ArithmeticExpression {
    private final ArithmeticExpression left, right;

    public Product(ArithmeticExpression left, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    private String label() {
        return "*";
    }

    /**
     * Evaluates the product of two double values.
     *
     * @param arg1 the first argument
     * @param arg2 the second argument
     * @return the product of arg1 and arg2
     */
    private double eval(double arg1, double arg2) {
        return arg1 * arg2;
    }

    // Updated asValue method to use the eval method
    @Override
    public double asValue() {
        return eval(left.asValue(), right.asValue());
    }

    @Override
    public String asString() {
        return "(" + left.asString() + label() + right.asString() + ")";
    }

    @Override
    public String toString() {
        return asString();
    }
}
