
/*
 * a. What are the abstract methods?

 The abstract methods in BinaryOperator are:

  protected abstract String label();
  protected abstract double eval(double arg1, double arg2);

 b. Should BinaryOperator implement ArithmeticExpression?

  Yes. Because all binary operations (Sum, Product, etc.) are arithmetic expressions and share 
  the same interface. So BinaryOperator should implement ArithmeticExpression.
 */

public class Product extends BinaryOperator {
    public Product(ArithmeticExpression left, ArithmeticExpression right) {
        super(left, right);
    }

    @Override
    protected String label() {
        return "*";
    }

    @Override
    protected double eval(double arg1, double arg2) {
        return arg1 * arg2;
    }
}
