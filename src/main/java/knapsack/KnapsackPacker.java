package knapsack;

import java.util.Arrays;

public class KnapsackPacker {
    private int maxWeight;
    Item[] availableItems;
    private int bestFoundPrice;
    private Item[] bestSet;
    private Item[] tempSet;
    private int bestIndex;


    public KnapsackPacker() {
    }

    public KnapsackPacker(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Item[] solve() {
        tempSet = new Item[availableItems.length];
        bestFoundPrice = 0;
        bestSet = new Item[availableItems.length];
        tempSet[0] = availableItems[0];
        findMostValuableCombination(0, availableItems[0].getPrice(), availableItems[0].getWeight());
        tempSet[0] = null;
        findMostValuableCombination(0, 0, 0);
        return bestSet;
    }

    public void findMostValuableCombination(int itemIndex, int price, int weight) {
        if(weight <= maxWeight && price > bestFoundPrice) {
            this.bestFoundPrice = price;
            this.bestIndex = itemIndex;
            bestSet = Arrays.copyOf(tempSet, tempSet.length);
        }
        if(promising(itemIndex)) {
            int nextItemIndex = itemIndex+1;
            Item nextItem = availableItems[nextItemIndex];
            tempSet[nextItemIndex] = nextItem;
            findMostValuableCombination(nextItemIndex, price + nextItem.getPrice(), weight + nextItem.getWeight());
            tempSet[nextItemIndex] = null;
            findMostValuableCombination(nextItemIndex, price, weight);
        }
    }

    private boolean promising(int index) {
        Knapsack currentSack = new Knapsack(maxWeight, tempSet);
        if(currentSack.isOverWeightLimit())
            return false;
        else {
            int maxPriceWithFactorial = currentSack.getFactorialMaximumPrice(availableItems, index);
            return maxPriceWithFactorial > bestFoundPrice;
        }
    }

    public void setAvailableItems(Item[] sortedItemsBasedOnValue) {
        this.availableItems = sortedItemsBasedOnValue;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}
