package knapsack;

import datastructures.DynamicObjectArray;

public class Knapsack {
    int maxWeight;
    DynamicObjectArray<Item> items;

    public Knapsack(int maxWeight) {
        this(maxWeight, new Item[10]);
    }

    public Knapsack(int maxWeight, Item[] items) {
        this.maxWeight = maxWeight;
        this.items = new DynamicObjectArray<Item>(items);
    }

    public Knapsack(int maxWeight, DynamicObjectArray<Item> items) {
        this.maxWeight = maxWeight;
        this.items = items;
    }

    public boolean isOverWeightLimit() {
        return getTotalWeight() > maxWeight;
    }

    public boolean isFull() {
        return getTotalWeight() >= maxWeight;
    }

    public float getTotalValue() {
        return getTotalPrice() / getTotalWeight();
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (Item item : items) {
            if (item != null)
                totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Item item : items) {
            if (item != null)
                totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int getFactorialMaximumPrice(Item[] availableItems, int itemIndex) {
        int tempPrice = getTotalPrice();
        int tempWeight = getTotalWeight();
        while (itemIndex < availableItems.length && withinWeightLimitWithItem(availableItems[itemIndex], tempWeight)) {
            tempWeight += availableItems[itemIndex].getWeight();
            tempPrice += availableItems[itemIndex].getPrice();
            itemIndex++;
        }
        if (itemIndex < availableItems.length) {
            Item lastItem = availableItems[itemIndex];
            tempPrice += (maxWeight - tempWeight) * (lastItem.getPrice() / lastItem.getWeight());
        }
        return tempPrice;
    }

    private boolean withinWeightLimitWithItem(Item item, int currentWeight) {
        return (currentWeight + item.getWeight()) <= maxWeight;
    }

    @Override
    public Knapsack clone() {
        return new Knapsack(maxWeight, items);
    }
}
