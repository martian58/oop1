public class Variable implements ArithmeticExpression {
    private final String name;
    private double value;

    public Variable(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public void set(double newValue) {
        this.value = newValue;
    }

    @Override
    public double asValue() {
        return value;
    }

    @Override
    public String asString() {
        return name;
    }
}
