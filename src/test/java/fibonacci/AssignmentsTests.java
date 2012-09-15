package fibonacci;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssignmentsTests {
    private Assignments assignments;

    @Before
    public void setUp() throws Exception {
        assignments = new Assignments();
        assignments.setCalculator(new FibonacciCalculator());
    }

    @Test
    public void lineCalculatorShouldCalculateCorrectAmountOfLines() throws Exception {
        assertEquals(1, assignments.numberOfCodeRowsExecutedForRecursiveFibonacciNumber(1));
        assertEquals(1, assignments.numberOfCodeRowsExecutedForRecursiveFibonacciNumber(2));
        assertEquals(4, assignments.numberOfCodeRowsExecutedForRecursiveFibonacciNumber(3));
        assertEquals(7, assignments.numberOfCodeRowsExecutedForRecursiveFibonacciNumber(4));
        assertEquals(13, assignments.numberOfCodeRowsExecutedForRecursiveFibonacciNumber(5));
    }

    @Test
    public void testRecursiveTime() throws Exception {
        assignments.maximumNumberRecursivelyCalculableWithin(2 * 1000);
    }

    @Test
    public void howLongToCalculateFibonacci400() throws Exception {
        assignments.numberOfYearsToCalculateFibonacciNumberRecursively(400);
    }
}
