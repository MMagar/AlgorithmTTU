package datastructures;

public class DynamicObjectArray<T> {
    protected Object[] array;
    private int freeIndex = 0;

    public DynamicObjectArray(int size) {
        array = new Object[size];
    }

    public void add(T input) {
        if (freeIndex == array.length - 1)
            increaseArray();
        array[freeIndex] = input;
        freeIndex++;
    }

    private void increaseArray() {
        Object[] biggerArray = new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            biggerArray[i] = array[i];
        }
        array = biggerArray;
    }

    public T remove() {
        if (freeIndex <= array.length / 4) {
            decreaseSize();
        }
        freeIndex--;
        return (T) array[freeIndex];
    }

    private void decreaseSize() {
        Object[] smallerArray = new Object[array.length / 2];
        System.arraycopy(array, 0, smallerArray, 0, freeIndex);
        array = smallerArray;
    }

    public T get(int index) {
        if(index >= freeIndex)
            throw new IndexOutOfBoundsException("Out of array bounds");
        return getObject(index);
    }

    /**
     * Get method that can return null if value is not set.
     * Needed for binary heap implementation.
     *
     * @param index
     * @return
     */
    public T getObject(int index) {
        T result;
        try {
            result = (T) array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            result = null;
        }
        return result;
    }

    public void put(int index, T value) {
        if (index >= freeIndex)
            freeIndex = index + 1;
        while (freeIndex > array.length) {
            increaseArray();
        }
        array[index] = value;
    }

    public int length() {
        return freeIndex;
    }
}
