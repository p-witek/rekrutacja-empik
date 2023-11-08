package pl.rekrutacja.empik.users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void calculateForZeroFollowers() {
        //given
        double calculations = new Calculator(0, 10).calculate();

        //when
        assertEquals(Double.POSITIVE_INFINITY, calculations);

    }

    @Test
    void calculateForMoreFollowers() {
        //given
        Calculator calculator = new Calculator(10, 8);

        //when
        double calculations = calculator.calculate();

        assertEquals(6, calculations);
    }
}