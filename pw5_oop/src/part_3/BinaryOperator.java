
/*
 * a. What are the abstract methods?

 The abstract methods in BinaryOperator are:

  protected abstract String label();
  protected abstract double eval(double arg1, double arg2);

 b. Should BinaryOperator implement ArithmeticExpression?

  Yes. Because all binary operations are arithmetic expressions and share 
  the same interface. So BinaryOperator should implement ArithmeticExpression.
 */

public abstract class BinaryOperator implements ArithmeticExpression {
    protected final ArithmeticExpression left, right;

    public BinaryOperator(ArithmeticExpression left, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    protected abstract String label();
    protected abstract double eval(double arg1, double arg2);

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
