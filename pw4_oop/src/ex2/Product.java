public class Product implements ArithmeticExpression {
    private final ArithmeticExpression left, right;

    public Product(ArithmeticExpression left, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double asValue() {
        return left.asValue() * right.asValue();
    }

    @Override
    public String asString() {
        return "(" + left.asString() + "*" + right.asString() + ")";
    }
}
