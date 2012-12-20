package knapsack;

import java.util.Arrays;

public class KnapsackPacker {
    private int maxWeight;
    Item[] availableItems;
    private int bestFoundPrice;
    private int bestFoundWeight;
    private Item[] bestSet;
    private Item[] tempSet;

    public KnapsackPacker() {
    }

    public KnapsackPacker(int maxWeight, Item[] items) {
        this.maxWeight = maxWeight;
        this.availableItems = items;
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
        if (weight <= maxWeight && price > bestFoundPrice) {
            this.bestFoundPrice = price;
            this.bestFoundWeight = weight;
            bestSet = Arrays.copyOf(tempSet, tempSet.length);
        }
        int nextItemIndex = itemIndex + 1;
        if (promising(itemIndex) && nextItemIndex < availableItems.length) {
            Item nextItem = availableItems[nextItemIndex];
            tempSet[nextItemIndex] = nextItem;
            findMostValuableCombination(nextItemIndex, price + nextItem.getPrice(), weight + nextItem.getWeight());
            tempSet[nextItemIndex] = null;
            findMostValuableCombination(nextItemIndex, price, weight);
        }
    }

    private boolean promising(int index) {
        Item[] currentItems = Arrays.copyOf(tempSet, index+1);
        Knapsack currentSack = new Knapsack(maxWeight, currentItems);
        if (currentSack.isOverWeightLimit())
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

    public int getBestFoundPrice() {
        return bestFoundPrice;
    }

    public int getBestFoundWeight() {
        return bestFoundWeight;
    }

    public Item[] getBestItemSet() {
        return bestSet;
    }
}
