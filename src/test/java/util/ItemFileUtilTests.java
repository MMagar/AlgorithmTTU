package util;

import datastructures.ComparableObjectHeap;
import knapsack.Item;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemFileUtilTests {
    ItemFileUtil util;

    @Before
    public void setUp() throws Exception {
        util = new ItemFileUtil("src/test/java/util/", "knapsackInput.in");
    }

    @Test
    public void sortItemsBasedOnValue() throws Exception {
        ComparableObjectHeap<Item> heap = new ComparableObjectHeap<Item>();
        Item leastValuable = new Item(1, 1);
        heap.enqueue(leastValuable);
        Item middleValuable = new Item(2, 1);
        heap.enqueue(middleValuable);
        Item mostValuable = new Item(3, 1);
        heap.enqueue(mostValuable);

        Item[] sortedItems = util.toReverseArray(heap);

        assertEquals(mostValuable, sortedItems[0]);
        assertEquals(middleValuable, sortedItems[1]);
        assertEquals(leastValuable, sortedItems[2]);
    }

    @Test
    public void readMaxWeightFromFile() throws Exception {
        util.readInput();

        assertEquals(2500, util.getMaxWeight());
    }

    @Test
    public void readItems() throws Exception {
        util.readInput();
        Item[] sortedItems = util.getItems();

        assertEquals(5, sortedItems[0].getPrice());
        assertEquals(5, sortedItems[0].getWeight());
        assertEquals(4, sortedItems[1].getPrice());
        assertEquals(5, sortedItems[1].getWeight());
        assertEquals(2, sortedItems[2].getPrice());
        assertEquals(3, sortedItems[2].getWeight());
    }

    @Test
    public void writeResultsToFile() throws Exception {
        util.setFileOut("knapsackOutput.out");
        Item[] items = {new Item(2,3), new Item(4,5)};

        util.writeResultsToFile(10, 12, items);

        String expectedContent = "10 12\n2 3\n4 5\n";
        assertEquals(expectedContent, FileUtils.readFileToString(util.getFileOut()));
    }
}
