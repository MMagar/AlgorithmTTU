package knapsack;

import datastructures.ComparableObjectHeap;

public class KnapsackPacker {
    private int maxWeight;
    Item[] availableItems;

    public KnapsackPacker(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void solve() {

    }

    public void setAvailableItems(Item[] availableItems) {
        this.availableItems = sortAvailableItemsBasedOnValue(availableItems);
    }

    private Item[] sortAvailableItemsBasedOnValue(Item[] arrayOfItems) {
        ComparableObjectHeap<Item> heap = new ComparableObjectHeap<Item>(arrayOfItems.length);
        for (int i = arrayOfItems.length - 1; i >= 0; i--) {
            heap.enqueue(arrayOfItems[i]);
        }
        return toReverseArray(heap, arrayOfItems.length);
    }

    public Item[] toReverseArray(ComparableObjectHeap<Item> heap, int size) {
        Item[] result = new Item[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = heap.dequeue();
        }
        return result;
    }
}
