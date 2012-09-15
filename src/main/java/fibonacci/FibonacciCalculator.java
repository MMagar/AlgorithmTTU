package fibonacci;

import java.util.ArrayList;
import java.util.Date;

public class FibonacciCalculator {

    public int recursive(int number) {
        if (number <= 2)
            return 1;
        return recursive(number - 1) + recursive(number - 2);
    }

    public int maximumNumberRecursivelyCalculableWithin(long maximumMilliseconds) {
        int lastFoundNumber = 1;
        long timeSpent = 0;
        Date start, end;
        for (lastFoundNumber = 1; timeSpent <= maximumMilliseconds; lastFoundNumber++) {
            start = new Date();
            recursive(lastFoundNumber);
            end = new Date();
            timeSpent = end.getTime() - start.getTime();
        }
        System.out.println("Within " + (new Float(maximumMilliseconds) / 1000) +
                " seconds the recursive algorithm calculated " + (lastFoundNumber - 1) + " fibonacci numbers.");
        return lastFoundNumber - 1;
    }

    public int numberOfCodeRowsExecutedForRecursiveFibonacciNumber(int number) {
        int twoNumbersAgo = 1;
        int oneNumberAgo = 1;
        int currentLinesOfCode = 1;
        for (int i = 3; i <= number; i++) {
            currentLinesOfCode = 2 + oneNumberAgo + twoNumbersAgo;
            twoNumbersAgo = oneNumberAgo;
            oneNumberAgo = currentLinesOfCode;
        }
        return currentLinesOfCode;
    }

    public double numberOfYearsToCalculateFibonacciNumberRecursively(int number) {
        int maximumNumberWithinTenSeconds = maximumNumberRecursivelyCalculableWithin(10 * 1000);
        int linesOfCodeExecuted = numberOfCodeRowsExecutedForRecursiveFibonacciNumber(maximumNumberWithinTenSeconds);
        System.out.println("Lines:" + linesOfCodeExecuted + " number:" + maximumNumberWithinTenSeconds);
        return 0;
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
}
