package datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryHeapTests {
    BinaryHeap heap;

    @Before
    public void setUp() throws Exception {
        heap = new BinaryHeap();
    }

    @Test
    public void enqueuingShouldEnqueueValue() throws Exception {
        heap.enqueue(3);
        assertEquals(3, heap.dequeue());
    }

    @Test
    public void dequeueingShouldReturnMinValue() throws Exception {
        heap.enqueue(2);
        heap.enqueue(1);
        heap.enqueue(1);
        heap.enqueue(4);
        assertEquals(1, heap.dequeue()); //values in heap 1,1,2,4
        assertEquals(1, heap.dequeue()); //values in heap 1,2,4
        assertEquals(2, heap.dequeue()); //values in heap 2,4
        heap.enqueue(5);
        assertEquals(4, heap.dequeue()); //values in heap 4,5
        heap.enqueue(3);
        assertEquals(3, heap.dequeue()); //values in heap 3,5
        assertEquals(5, heap.dequeue()); //values in heap 5
    }

    @Test
    public void heapShouldBeEmptyIfItContainsNoElements() throws Exception {
        assertTrue(heap.isEmpty());
        heap.enqueue(1);
        assertFalse(heap.isEmpty()); //heap should have:1
        heap.enqueue(2);
        heap.enqueue(5);
        assertFalse(heap.isEmpty()); //heap should have:1,2,4
        heap.dequeue();
        heap.dequeue();
        heap.dequeue();
        assertTrue(heap.isEmpty());
    }
}
