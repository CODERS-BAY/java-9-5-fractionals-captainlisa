package at.codersbay.datastructures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FractionalTest6 {

    @Test
    public void testAddNaturalNumber() {
            assertThat(new Fractional(3, 7).add(3))
                .isEqualTo(new Fractional(24, 7));
    }

    @Test
    public void testAddZero() {
        assertThat(new Fractional(3, 7).add(0))
                .isEqualTo(new Fractional(3, 7));
    }

    @Test
    public void testAddFractional() {
        assertThat(new Fractional(2, 4).add(new Fractional(3, 8)))
                .isEqualTo(new Fractional(7, 8));
    }

    @Test
    public void testAddFractional2() {
        assertThat(new Fractional(2, 5).add(new Fractional(1, 3)))
                .isEqualTo(new Fractional(11, 15));
    }

    @Test
    public void testAddZeroFractional() {
        assertThat(new Fractional(2, 5).add(new Fractional(0, 11)))
                .isEqualTo(new Fractional(2, 5));
    }
}
