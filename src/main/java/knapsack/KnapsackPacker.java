package knapsack;

import datastructures.ComparableObjectHeap;
import datastructures.DynamicObjectArray;
import datastructures.Stack;

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

    private int indexOfNextLeastValuableItem(Item[] availableItems, Stack sortedIndexes) {
        float lastValue = availableItems[sortedIndexes.peekAt(0)].getValue();
        float candidateWithLeastValue;

        for (int i = availableItems.length; i >= 0; i--) {
            if (!sortedIndexes.contains(i)) {
            }
        }
        return 1;
    }


    public DynamicObjectArray<Item> toArray(ComparableObjectHeap<Item> heap, int size) {
        DynamicObjectArray<Item> result = new DynamicObjectArray<Item>(size);
        for (int i = 0; i < size; i++) {
            result.add(heap.dequeue());
        }
        return result;
    }

    public Item[] toReverseArray(ComparableObjectHeap<Item> heap, int size) {
        Item[] result = new Item[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = heap.dequeue();
        }
        return result;
    }
}
