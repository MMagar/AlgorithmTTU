package datastructures;

public class Stack {
    private StackNode firstNode = null;
    private int size = 0;

    public void push(int x) {
        StackNode newNode = new StackNode(x);
        newNode.setNextNode(firstNode);
        firstNode = newNode;
        size++;
    }

    public int pop() {
        int val = firstNode.getValue();
        firstNode = firstNode.getNextNode();
        size--;
        return val;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public boolean contains(int number) {
        StackNode node = firstNode;
        while (node != null) {
            if (node.getValue() == number)
                return true;
            node = node.getNextNode();
        }
        return false;
    }

    public int peekAt(int index) {
        StackNode currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getValue();
    }



    public int[] toArray() {
        int[] result = new int[size];
        StackNode node = firstNode;
        for (int i = 0; i < size; i++) {
            result[i] = node.getValue();
            node = node.getNextNode();
        }
        return result;
    }
}
