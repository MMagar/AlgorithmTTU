package fibonacci;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciCalculatorTests {
    FibonacciCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new FibonacciCalculator();
    }

    @Test
    public void recursiveMethodShouldFindCorrectNumbers() throws Exception {
        assertEquals(1, calculator.recursive(1));
        assertEquals(8, calculator.recursive(6));
        assertEquals(1, calculator.recursive(2));
        assertEquals(89, calculator.recursive(11));
    }

    @Test
    public void iterativeMethodShouldFindCorrectNumbers() throws Exception {
        assertEquals(1, calculator.iterative(1));
        assertEquals(8, calculator.iterative(6));
        assertEquals(1, calculator.iterative(2));
        assertEquals(89, calculator.iterative(11));
    }

}
