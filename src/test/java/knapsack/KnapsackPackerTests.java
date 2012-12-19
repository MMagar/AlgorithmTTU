package knapsack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackPackerTests {
    KnapsackPacker packer;

    @Before
    public void setUp() throws Exception {
        packer = new KnapsackPacker();
    }

    @Test
    public void sortStartingItems() throws Exception {
        packer.setMaxWeight(10);
        Item leastValuable = new Item(1, 1);
        Item middleValuable = new Item(2, 1);
        Item mostValuable = new Item(3, 1);
        Item[] unSortedItems = {middleValuable, leastValuable, mostValuable};

        packer.setAvailableItems(unSortedItems);

        assertEquals(mostValuable, packer.availableItems[0]);
        assertEquals(middleValuable, packer.availableItems[1]);
        assertEquals(leastValuable, packer.availableItems[2]);
    }

    @Test
    public void findEasySolution() throws Exception {
        packer.setMaxWeight(10);
        Item valuableItem = new Item(5,5);
        Item valuableItem2 = new Item(2,3);
        Item pointlessItem = new Item(1,10);
        Item[] items = {valuableItem, valuableItem2, pointlessItem};
        packer.setAvailableItems(items);

        Item[] result = packer.solve();

        assertEquals(result[0],valuableItem);
        assertEquals(result[1],valuableItem2);
    }

}
