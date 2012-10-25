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

    /**
     * Get method that can return null if value is not set.
     * Needed for binary heap implementation.
     * @param index
     * @return
     */
    public Integer getObject(int index) {
        Integer result;
        try{
            result = array[index];
        }catch (ArrayIndexOutOfBoundsException e){
            result = null;
        }
        return result;
    }

    public void put(int index, Integer value) {
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
