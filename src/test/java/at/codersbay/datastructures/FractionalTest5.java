package at.codersbay.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FractionalTest5 {

    @Test
    public void testDivisionWithNaturalNumber() {
        assertThat(new Fractional(1, 2).divide(3))
                .isEqualTo(new Fractional(1, 6));
    }

    @Test
    public void testDivisionWithFour() {
        assertThat(new Fractional(1, 3).divide(4))
                .isEqualTo(new Fractional(1, 12));
    }

    @Test
    public void testDivisionWithZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new Fractional(1, 9).divide(0),
                "You cannot divide through zero!");
    }

    @Test
    public void testDivisionWithHalf() {
        assertThat(new Fractional(1, 2).divide(new Fractional(1, 2)))
                .isEqualTo(new Fractional(2, 2));
    }

    @Test
    public void testDivisionComplex() {
        assertThat(new Fractional(2, 3).divide(new Fractional(7, 8)))
                .isEqualTo(new Fractional(16, 21));
    }

    @Test
    public void testDivisionWithNegatives() {
        assertThat(new Fractional(-2, 3).divide(new Fractional(7, -3)))
                .isEqualTo(new Fractional(6, 21));
    }

}
