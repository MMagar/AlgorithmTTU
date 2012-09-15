package fibonacci;

import java.util.Date;

public class Assignments {
    private FibonacciCalculator calculator;

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

    public int maximumNumberRecursivelyCalculableWithin(long maximumMilliseconds) {
        int lastFoundNumber = 1;
        long timeSpent = 0;
        Date start, end;
        for (lastFoundNumber = 1; timeSpent <= maximumMilliseconds; lastFoundNumber++) {
            start = new Date();
            calculator.recursive(lastFoundNumber);
            end = new Date();
            timeSpent = end.getTime() - start.getTime();
        }
        System.out.println("Within " + (new Float(maximumMilliseconds) / 1000) +
                " seconds the recursive algorithm calculated " + (lastFoundNumber - 1) + " fibonacci numbers.");
        return lastFoundNumber - 1;
    }

    public void setCalculator(FibonacciCalculator calculator) {
        this.calculator = calculator;
    }
}
