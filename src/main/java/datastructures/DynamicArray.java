package datastructures;

public class DynamicArray {
    Integer[] array;
    private int freeIndex = 0;

    public DynamicArray(int size) {
        array = new Integer[size];
    }

    public void add(int number) {
        if (freeIndex == array.length - 1)
            increaseArray();
        array[freeIndex] = number;
        freeIndex++;
    }

    private void increaseArray() {
        Integer[] biggerArray = new Integer[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            biggerArray[i] = array[i];
        }
        array = biggerArray;
    }

    public int remove() {
        if (freeIndex <= array.length / 4) {
            decreaseSize();
        }
        freeIndex--;
        return array[freeIndex];
    }

    private void decreaseSize() {
        Integer[] smallerArray = new Integer[array.length / 2];
        for (int i = 0; i < freeIndex; i++) {
            smallerArray[i] = array[i];
        }
        array = smallerArray;
    }

    public int get(int index) {
        return getObject(index);
    }

    public Integer getObject(int index) {
        return array[index];
    }

    public void put(int index, int value) {
        if (index >= freeIndex)
            freeIndex = index+1;
        while (freeIndex > array.length) {
            increaseArray();
        }
        array[index] = value;
    }

    public int length() {
        return freeIndex;
    }
}
