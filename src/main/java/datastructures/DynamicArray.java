package datastructures;

public class DynamicArray {
    int[] array;
    private int freeIndex = 0;

    public DynamicArray(int size) {
        array = new int[size];
    }

    public void add(int number) {
        if (freeIndex == array.length - 1)
            increaseArray();
        array[freeIndex] = number;
        freeIndex++;
    }

    private void increaseArray() {
        int[] biggerArray = new int[array.length * 2];
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
        int[] smallerArray = new int[array.length / 2];
        for (int i = 0; i < freeIndex; i++) {
            smallerArray[i] = array[i];
        }
        array = smallerArray;
    }

    public int get(int index) {
        if (index >= freeIndex)
            throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }

    public void put(int index, int value) {
        if (index >= freeIndex)
            throw new ArrayIndexOutOfBoundsException();
        array[index] = value;
    }

    public int length() {
        return freeIndex;
    }
}
