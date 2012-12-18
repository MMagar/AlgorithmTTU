package datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTests {
    Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack();
    }

    @Test
    public void pushShouldAddNewNode() throws Exception {
        int testNumber1 = 11;
        int testNumber2 = 22;
        int testNumber3 = 33;
        stack.push(testNumber1);
        stack.push(testNumber2);
        stack.push(testNumber3);

        assertEquals(testNumber3, stack.pop());
        assertEquals(testNumber2, stack.pop());
        assertEquals(testNumber1, stack.pop());
    }

    @Test
    public void isEmptyShouldReturnTrueWhenNoNodesAreInStack() throws Exception {
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void containsNumberTest() throws Exception {
        assertFalse(stack.contains(1));

        stack.push(1);
        stack.push(3);
        stack.push(5);

        assertTrue(stack.contains(1));
        assertTrue(stack.contains(3));
        assertTrue(stack.contains(5));
    }

    @Test
    public void toArrayTest() throws Exception {
        stack.push(3);
        stack.push(2);
        stack.push(1);
        int[] arrayExpected = {1, 2, 3};
        int[] arrayActual = stack.toArray();
        for (int i = 0; i < arrayExpected.length; i++) {
            assertEquals(arrayExpected[i], arrayActual[i]);
        }
    }
}
