package datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
