public class Division implements ArithmeticExpression {
    private final ArithmeticExpression numerator, denominator;

    public Division(ArithmeticExpression numerator, ArithmeticExpression denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public double asValue() {
        return numerator.asValue() / denominator.asValue();
    }

    @Override
    public String asString() {
        return "(" + numerator.asString() + "/" + denominator.asString() + ")";
    }
}
