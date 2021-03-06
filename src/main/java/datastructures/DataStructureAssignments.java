package datastructures;

import util.FileUtil;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Class that implements the required assignments by reading input from a file
 * and then completes tasks using the data structures
 */
public class DataStructureAssignments {
    private Stack stack = new Stack();
    private BinaryHeap heap = new BinaryHeap();
    private FileUtil fileUtil;
    private ArrayList<Integer> inputNumbers;
    private ArrayList<Integer> outputMagNumbers = new ArrayList<Integer>();
    private ArrayList<Integer> outputPriNumbers = new ArrayList<Integer>();

    public DataStructureAssignments(FileUtil util) {
        this.fileUtil = util;
    }

    public void readInput() throws IOException {
        inputNumbers = fileUtil.readInputNumbers();
    }

    public void processNumbers() {
        for (Integer number : inputNumbers) {
            processNumber(number);
        }
    }

    private void processNumber(Integer number) {
        if (number > 0) {
            stack.push(number);
            heap.enqueue(number);
        } else if (number == 0) {
            clearStackToArray();
            clearHeapToArray();
        } else if (number < 0) {
            int absoluteNumber = Math.abs(number);
            removeElementsFromStackToArray(absoluteNumber);
            removeElementsFromHeapToArray(absoluteNumber);
        }
    }

    private void removeElementsFromStackToArray(int numberOfElementsToRemove) {
        while (!stack.isEmpty() && numberOfElementsToRemove > 0) {
            outputMagNumbers.add(stack.pop());
            numberOfElementsToRemove--;
        }
    }

    private void removeElementsFromHeapToArray(int numberOfElementsToRemove) {
        while (!heap.isEmpty() && numberOfElementsToRemove > 0) {
            outputPriNumbers.add(heap.dequeue());
            numberOfElementsToRemove--;
        }
    }

    private void clearStackToArray() {
        while (!stack.isEmpty()) {
            outputMagNumbers.add(stack.pop());
        }
    }

    private void clearHeapToArray() {
        while (!heap.isEmpty()) {
            outputPriNumbers.add(heap.dequeue());
        }
    }

    public void saveResults() throws IOException {
        fileUtil.writeResultsToFile(outputMagNumbers, "output-mag");
        fileUtil.writeResultsToFile(outputPriNumbers, "output-pri");
    }
}
