package fibonacci;

import java.util.ArrayList;

public class FibonacciCalculator {

    public int recursive(int number) {
        if (number <= 2)
            return 1;
        return recursive(number - 1) + recursive(number - 2);
    }

    public int iterative(int number) {
        int twoNumbersAgo = 1;
        int oneNumberAgo = 1;
        int lastFibonacciNumber = 1;
        for (int i = 2; i < number; i++) {
            lastFibonacciNumber = oneNumberAgo + twoNumbersAgo;
            twoNumbersAgo = oneNumberAgo;
            oneNumberAgo = lastFibonacciNumber;
        }
        return lastFibonacciNumber;
    }

    public ArrayList<Integer> recursiveNumbers(ArrayList<Integer> inputNumbers) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer number : inputNumbers) {
            result.add(recursive(number));
        }
        return result;
    }

    public ArrayList<Integer> iterativeNumbers(ArrayList<Integer> inputNumbers) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer number : inputNumbers) {
            result.add(recursive(number));
        }
        return result;
    }
}
