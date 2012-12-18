package knapsack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class KnapsackTests {

    @Test
    public void testTotalWeight() throws Exception {
        Item item1 = new Item(1, 1);
        Item item2 = new Item(2, 2);
        Knapsack knapsack = new Knapsack(10, item1, item2);

        assertEquals(3, knapsack.getTotalWeight());
    }

    @Test
    public void testOverweight() throws Exception {
        Item item1 = new Item(1, 5);
        Item item2 = new Item(1, 5);
        Knapsack knapsack = new Knapsack(9, item1, item2);

        assertTrue(knapsack.isOverWeightLimit());
    }
}
