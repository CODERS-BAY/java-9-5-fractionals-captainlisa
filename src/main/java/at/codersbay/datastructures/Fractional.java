package at.codersbay.datastructures;

/**
 * A Fractional is a class that consists of a numerator and a denominator
 * e.g.: 1/2, 1/3, 24/37, ..
 */
public class Fractional {

    private Integer numerator;
    private Integer denominator;

    public Fractional(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Integer getNumerator() {
        return numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }

    public Float asFloat() {
        Float num = this.numerator.floatValue();
        Float denom = this.denominator.floatValue();
        return -1f;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO implement to fix tests in FractionalTest3
        return false;
    }

    public Fractional multiply(Fractional other) {
        // TODO implement to fix tests in FractionalTest4
        return new Fractional(1, 1);
    }

    public Fractional multiply(Integer other) {
        // TODO implement to fix tests in FractionalTest4
        return new Fractional(1, 1);
    }

    public Fractional divide(Fractional other) {
        // TODO implement to fix tests in FractionalTest5
        return new Fractional(1, 1);
    }

    public Fractional divide(Integer other) {
        // TODO implement to fix tests in FractionalTest5
        return new Fractional(1, 1);
    }

    public Fractional add(Fractional other) {
        // TODO implement to fix tests in FractionalTest6
        return new Fractional(1, 1);
    }

    public Fractional add(Integer other) {
        // TODO implement to fix tests in FractionalTest6
        return new Fractional(1, 1);
    }

    public Fractional subtract(Fractional other) {
        // TODO implement to fix tests in FractionalTest7
        return new Fractional(1, 1);
    }

    public Fractional subtract(Integer other) {
        // TODO implement to fix tests in FractionalTest7
        return new Fractional(1, 1);
    }

}