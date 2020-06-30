package at.codersbay.datastructures;

public class Main {

    public static void main(String[] args) {

        Fractional fractional = new Fractional(1,3);
        Fractional fractional2 = new Fractional(2,6);
        fractional2.reduceToLowestTerms();

        System.out.println(fractional.asFloat());
        System.out.println(fractional2.getNumerator());
        System.out.println(fractional2.getDenominator());

    }
}
