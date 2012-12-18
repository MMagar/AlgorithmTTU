package knapsack;

import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTests {

    @Test
    public void itemValueShouldDividePrizeWithWeight() throws Exception {
        Item item = new Item();
        item.setPrice(2);
        item.setWeight(2);
        assertTrue(new Float(1).equals(item.getValue()));
    }

    @Test
    public void itemValueShouldBeComparable() throws Exception {
        Item moreValuableItem = new Item(2,2);
        Item lessValuableItem = new Item(1,2);

        assertTrue(moreValuableItem.isMoreValuableThan(lessValuableItem));
        assertFalse(lessValuableItem.isMoreValuableThan(moreValuableItem));
    }

}
