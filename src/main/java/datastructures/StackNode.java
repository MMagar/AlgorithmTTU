package datastructures;

public class StackNode {
    private int value;
    private StackNode nextNode;

    public StackNode(int value) {
        this.value = value;
    }

    public StackNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(StackNode nextNode) {
        this.nextNode = nextNode;
    }

    public int getValue() {
        return value;
    }
}
