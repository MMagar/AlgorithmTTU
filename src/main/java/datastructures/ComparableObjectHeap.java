package datastructures;

public class ComparableObjectHeap<T extends Comparable> {
    private DynamicObjectArray<T> array;

    public ComparableObjectHeap() {
        array = new DynamicObjectArray<T>(8);
    }

    public ComparableObjectHeap(int size) {
        array = new DynamicObjectArray<T>(size);
    }

    public void enqueue(T x) {
        enqueueToNode(1, x);
    }

    private void enqueueToNode(int indexInArray, T value) {
        T nodeValue = array.getObject(indexInArray);
        if (nodeValue == null) {
            array.put(indexInArray, value);
        } else if (value.compareTo(nodeValue) < 0) {
            enqueueToLeftNodeOf(indexInArray, value);
        } else {
            enqueueToRightNodeOf(indexInArray, value);
        }
    }

    private void enqueueToLeftNodeOf(int indexOfHead, T value) {
        enqueueToNode(getIndexOfLeft(indexOfHead), value);
    }

    private void enqueueToRightNodeOf(int indexOfHead, T value) {
        enqueueToNode(getIndexOfRight(indexOfHead), value);
    }

    public T dequeue() {
        return dequeueMinOfNode(1);
    }

    private T dequeueMinOfNode(int indexInArray) {
        int indexOfLeftNode = getIndexOfLeft(indexInArray);
        if (array.getObject(indexOfLeftNode) == null) {
            return removeNodeAt(indexInArray);
        } else {
            return dequeueMinOfNode(indexOfLeftNode);
        }
    }

    private T removeNodeAt(int indexInArray) {
        T nodeValue = array.getObject(indexInArray);
        Integer indexOfRightNode = getIndexOfRight(indexInArray);
        T valueOnRight = array.getObject(indexOfRightNode);
        if (valueOnRight == null) {
            array.put(indexInArray, null);
        } else {
            array.put(indexInArray, dequeueMinOfNode(indexOfRightNode));
        }
        return nodeValue;
    }

    private int getIndexOfLeft(int head) {
        return 2 * head;
    }

    private int getIndexOfRight(int head) {
        return 2 * head + 1;
    }

    public boolean isEmpty() {
        return array.getObject(1) == null;
    }

}
