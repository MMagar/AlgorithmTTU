package datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DynamicArrayTests {
    DynamicArray array;
    int size = 2;

    @Before
    public void setUp() throws Exception {
        array = new DynamicArray(size);
    }

    @Test
    public void addingShouldAddNewIntegers() throws Exception {
        array.add(1);
        array.add(3);

        assertEquals(1, array.get(0));
        assertEquals(3, array.get(1));
    }

    @Test
    public void arrayShouldDynamicallyIncreaseInSize() throws Exception {
        for (int i = 0; i <= size; i++) {
            array.add(i);
        }
        assertEquals(size * 2, array.array.length);
        for (int i = 0; i <= size; i++) {
            assertEquals(i, array.get(i));
        }
    }

    @Test
    public void removingShouldReturnElements() throws Exception {
        array.add(0);
        array.add(1);

        assertEquals(1, array.remove());
        assertEquals(0, array.remove());
    }

    @Test
    public void removingShouldDynamicallyDecreaseSize() throws Exception {
        for (int i = 0; i <= size; i++) {
            array.add(i);
        }
        assertEquals(size * 2, array.array.length);
        for (int i = size; i >= 0; i--) {
            assertEquals(i, array.remove());
        }
        assertEquals(size, array.array.length);
    }

    @Test
    public void removingShouldReduceArraySize() throws Exception {
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        assertEquals(8, array.array.length);

        array.remove();
        array.remove();
        array.remove();
        array.remove();
        assertEquals(4, array.array.length);
    }

    @Test(expected = NullPointerException.class)
    public void getShouldThrowExceptionWhenOutOfBounds() throws Exception {
        array.get(0);
    }

    @Test
    public void getObjectShouldReturnNullIfValueNotSet() throws Exception {
        assertNull(array.getObject(0));
    }

    @Test
    public void putShouldUpdateValue() throws Exception {
        array.add(1);
        array.add(2);
        array.add(3);

        assertEquals(2, array.get(1));
        array.put(1, 4);
        assertEquals(4, array.get(1));
    }

    @Test
    public void putShouldDynamicallyIncreaseArraySize() throws Exception {
        array.put(size, 2);
        assertEquals(2, array.get(size));
        array.add(3);
        assertEquals(3, array.remove());
    }

    @Test
    public void lengthShouldReturnNumberOfElementsInArray() throws Exception {
        assertEquals(0, array.length());

        array.add(1);
        assertEquals(1, array.length());

        array.add(23);
        assertEquals(2, array.length());

        array.remove();
        assertEquals(1, array.length());

        array.remove();
        assertEquals(0, array.length());
    }
}
