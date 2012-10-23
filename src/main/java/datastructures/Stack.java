package datastructures;

public class Stack {
    private StackNode firstNode = null;

    public void push(int x) {
        StackNode newNode = new StackNode(x);
        newNode.setNextNode(firstNode);
        firstNode = newNode;
    }

    public int pop() {
        int val = firstNode.getValue();
        firstNode = firstNode.getNextNode();
        return val;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }
}
