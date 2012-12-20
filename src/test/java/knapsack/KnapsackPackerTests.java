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

    @Test
    public void solveBigKnapsackWithFewItems() {
        packer.setMaxWeight(100);
        Item valuableItem = new Item(5,5);
        Item valuableItem2 = new Item(2,3);
        Item pointlessItem = new Item(1,10);
        Item[] items = {valuableItem, valuableItem2, pointlessItem};
        packer.setAvailableItems(items);

        Item[] result = packer.solve();

        assertEquals(3, result.length);
        assertEquals(valuableItem, result[0]);
        assertEquals(valuableItem2, result[1]);
        assertEquals(pointlessItem, result[2]);
    }

}
