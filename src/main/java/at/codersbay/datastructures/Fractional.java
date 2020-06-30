package at.codersbay.datastructures;

/**
 * A Fractional is a class that consists of a numerator and a denominator
 * e.g.: 1/2, 1/3, 24/37, ..
 */
public class Fractional {

    private Integer numerator;
    private Integer denominator;

    public Fractional(Integer numerator, Integer denominator) {
        if (numerator == null || denominator == null) {
            throw new IllegalArgumentException("Denominator cannot be null");
        } else if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fractional() {
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
        Float frac = num / denom;

        return frac;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Fractional newFrac = (Fractional) obj;

        if (this.numerator == newFrac.numerator && this.denominator == newFrac.denominator) {
            return true;
        } else {
            this.reduceToLowestTerms();
            newFrac.reduceToLowestTerms();

            if (this.numerator == 0 && newFrac.numerator == 0) {
                return true;
            } else {
                return numerator == newFrac.numerator && denominator == newFrac.denominator;
            }

        }

    }

    public void reduceToLowestTerms() {

        int i = Math.min(this.numerator, this.denominator);

        if (i == 0) {
            return;
        }

        while ((this.numerator % i != 0) || (this.denominator % i != 0)) {
            i--;
        }

        this.numerator = this.numerator / i;
        this.denominator = this.denominator / i;

    }

    public Fractional multiply(Fractional other) {

        Integer newNumerator = this.numerator * other.numerator;
        Integer newDenominator = this.denominator * other.denominator;

        return new Fractional(newNumerator, newDenominator);
    }

    public Fractional multiply(Integer other) {

        Fractional multiplier = new Fractional(other, 1);

        Integer newNumerator = this.numerator * multiplier.numerator;
        Integer newDenominator = this.denominator * multiplier.denominator;

        return new Fractional(newNumerator, newDenominator);
    }

    public Fractional divide(Fractional other) {

        Integer newNumerator = this.numerator * other.denominator;
        Integer newDenominator = this.denominator * other.numerator;

        return new Fractional(newNumerator, newDenominator);
    }

    public Fractional divide(Integer other) {

        Fractional multiplier = new Fractional(other, 1);

        //if ()
        Integer newNumerator = this.numerator * multiplier.denominator;
        Integer newDenominator = this.denominator * multiplier.numerator;

        return new Fractional(newNumerator, newDenominator);
    }

    public Fractional add(Fractional other) {

        Integer newNum;
        int gcd;

        if (this.denominator == other.denominator) {
            newNum = this.numerator + other.denominator;
        } else {
            //find greatest common denominator
            gcd = findCommonDenominator(other.denominator);

            //extend numerator
            extendNumerator(other, gcd);

            this.denominator = gcd;

            newNum = this.numerator + other.numerator;
        }

        return new Fractional(newNum, this.denominator);
    }

    public Fractional add(Integer other) {

        Integer newNum;

        Fractional addend = new Fractional(other, 1);
        int otherDenominator = addend.getDenominator();

        //find greatest common denominator
        int gcd = findCommonDenominatorInt(otherDenominator);

        //extend numerators
        other = extendNumeratorInt(other, otherDenominator, gcd);

        newNum = this.numerator + other;

        return new Fractional(newNum, gcd);
    }

    private Integer extendNumeratorInt(Integer other, int otherDenominator, int gcd) {
        if (this.denominator != gcd) {
            int thisMultiplicand = gcd / this.denominator;
            this.numerator *= thisMultiplicand;
        }
        if (otherDenominator != gcd) {
            int otherMultiplicand = gcd / otherDenominator;
            other *= otherMultiplicand;
        }
        return other;
    }

    public Fractional subtract(Fractional other) {

        Integer newNum;
        int gcd;

        if (this.denominator == other.denominator) {
            newNum = this.numerator - other.numerator;
        } else {
            //find greatest common denominator
            gcd = findCommonDenominator(other.denominator);

            //extend numerator
            extendNumerator(other, gcd);

            this.denominator = gcd;

            newNum = this.numerator - other.numerator;
        }

        return new Fractional(newNum, this.denominator);
    }

    public Fractional subtract(Integer other) {

        Integer newNum;

        Fractional addend = new Fractional(other, 1);
        int otherDenominator = addend.getDenominator();

        //find greatest common denominator
        int gcd = findCommonDenominatorInt(otherDenominator);

        //extend numerators
        other = extendNumeratorInt(other, otherDenominator, gcd);

        newNum = this.numerator - other;

        return new Fractional(newNum, gcd);
    }

    private int findCommonDenominatorInt(int otherDenominator) {
        int gcd = Math.max(this.denominator, otherDenominator);
        while (this.denominator % gcd != 0 && otherDenominator % gcd != 0) {
            gcd++;
        }
        return gcd;
    }

    private int findCommonDenominator(int otherDenominator) {
        int gcd;
        gcd = Math.max(this.denominator, otherDenominator);
        while (gcd % this.denominator != 0 || gcd % otherDenominator != 0) {
            gcd++;
        }
        return gcd;
    }

    private void extendNumerator(Fractional other, int gcd) {
        other.numerator = extendNumeratorInt(other.numerator, other.denominator, gcd);
    }

    @Override
    public String toString() {
        return "Fractional{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}