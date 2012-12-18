package knapsack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackPackerTests {
    KnapsackPacker packer;

    @Before
    public void setUp() throws Exception {
        packer = new KnapsackPacker(10);
    }

    @Test
    public void sortStartingItems() throws Exception {
        Item leastValuable = new Item(1, 1);
        Item middleValuable = new Item(2, 1);
        Item mostValuable = new Item(3, 1);
        Item[] unSortedItems = {middleValuable, leastValuable, mostValuable};

        packer.setAvailableItems(unSortedItems);

        assertEquals(mostValuable, packer.availableItems[0]);
        assertEquals(middleValuable, packer.availableItems[1]);
        assertEquals(leastValuable, packer.availableItems[2]);
    }
}
