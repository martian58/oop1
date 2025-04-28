public class Variable implements ArithmeticExpression {
    private final String name;
    private double value;

    public Variable(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public void set(double newvalue) {
        this.value = newvalue;
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
