package fibonacci;

import util.FileUtil;

import java.io.*;
import java.util.ArrayList;

/**
 * Martin Mägar
 * 073819
 * https://github.com/MMagar/AlgorithmTTU
 */
public class Main {

    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil("src/main/java/fibonacci/", "input.in");
        FibonacciCalculator calculator = new FibonacciCalculator();
        Assignments assignments = new Assignments();
        assignments.setCalculator(calculator);

        try {
            ArrayList<Integer> inputNumbers = fileUtil.readInputNumbers();

            ArrayList<Integer> outputNumbers = calculator.recursiveNumbers(inputNumbers);
            fileUtil.writeResultsToFile(outputNumbers, "recursive.out");

            outputNumbers = calculator.iterativeNumbers(inputNumbers);
            fileUtil.writeResultsToFile(outputNumbers, "iterative.out");

            System.out.println("Maximum number calculable in 10 seconds...");
            System.out.println(assignments.maximumNumberRecursivelyCalculableWithin(1000 * 10));
            System.out.println("Calculating 400th fibonacci number takes...");
            System.out.println(assignments.numberOfYearsToCalculateFibonacciNumberRecursively(400) + " years.");
        } catch (IOException e) {
            System.out.println("Exception while reading/writing file. " + e);
        }

    }
}

