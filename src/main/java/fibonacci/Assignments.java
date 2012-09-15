package fibonacci;

import java.math.BigInteger;
import java.util.Date;

public class Assignments {
    private static final int MILLISECONDS_IN_A_YEAR = 1000 * 60 * 60 * 24 * 365;
    private FibonacciCalculator calculator;


    public BigInteger numberOfCodeRowsExecutedForRecursiveFibonacciNumber(int number) {
        BigInteger twoNumbersAgo = new BigInteger("1");
        BigInteger oneNumberAgo = new BigInteger("1");
        BigInteger currentLinesOfCode = new BigInteger("1");
        for (int i = 3; i <= number; i++) {
            currentLinesOfCode = new BigInteger("2").add(oneNumberAgo).add(twoNumbersAgo);
            twoNumbersAgo = new BigInteger(oneNumberAgo.toString());
            oneNumberAgo = new BigInteger(currentLinesOfCode.toString());
        }
        return currentLinesOfCode;
    }

    public BigInteger numberOfYearsToCalculateFibonacciNumberRecursively(int number) {
        BigInteger linesExecutedPerMillisecond = linesMachineCanExecutePerMillisecond();
        BigInteger linesToCalculateProvidedNumber = numberOfCodeRowsExecutedForRecursiveFibonacciNumber(number);
        BigInteger millisecondsToCalculateProvidedNumber = linesToCalculateProvidedNumber.divide(linesExecutedPerMillisecond);
        BigInteger yearsToCalculateProvidedNumber = millisecondsToCalculateProvidedNumber.divide(new BigInteger(MILLISECONDS_IN_A_YEAR + ""));
        return yearsToCalculateProvidedNumber;
    }

    public BigInteger linesMachineCanExecutePerMillisecond() {
        int timeToSpendMeasuring = 1000 * 10;
        int largestNumberFound = maximumNumberRecursivelyCalculableWithin(timeToSpendMeasuring);
        BigInteger linesExecuted = numberOfCodeRowsExecutedForRecursiveFibonacciNumber(largestNumberFound);
        return linesExecuted.divide(new BigInteger(timeToSpendMeasuring + ""));
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
