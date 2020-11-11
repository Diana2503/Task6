package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double x = readDouble("x");
        double n = readDouble("n");
        double e = readDouble("e");

        if (!checkEnteredValueIncludedInInterval(x)) {
            System.out.println("The input value x isn't included in the range (-1, 1).");
            return;
        }

        double SumOfNTermsOfSequence = calculateSumOfTermsOfSequence(x, n);
        printResult("The sum of the n terms of the given sequence: ", SumOfNTermsOfSequence);

        RowCalculateResult SumOfTermsGreaterThanEpsilon = calculateSumOfTermsGreaterThenEpsilon(x, n, e);
        printEpsilonRelatedResult("in absolute value: ", SumOfTermsGreaterThanEpsilon);

        RowCalculateResult SumOfTermsGreaterThanEpsilonDividedByTen = calculateSumOfTermsGreaterThenEpsilon(x, n, e / 10);
        printEpsilonRelatedResult("divided by ten in absolute value: ", SumOfTermsGreaterThanEpsilonDividedByTen);

        double functionValue = calculateFunctionValue(x);
        printResult("Function value: ", functionValue);
    }

    private static double readDouble(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s: ", name);
        return scanner.nextDouble();
    }

    public static boolean checkEnteredValueIncludedInInterval(double x) {
        return x > -1 && x < 1;
    }

    public static double calculateSumOfTermsOfSequence(double x, double n) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += getNTermsOfSequence(x, i);
        }
        return sum;
    }

    public static RowCalculateResult calculateSumOfTermsGreaterThenEpsilon(double x, double n, double e) {
        double sum = 0;
        int iteration = 1;
        for (int i = 0; i <= n; i++) {
            if (getNTermsOfSequence(x, i) > e) {
                sum += getNTermsOfSequence(x, i);
                iteration++;
            }
        }
        return new RowCalculateResult(iteration, sum);
    }

    public static double getNTermsOfSequence(double x, double n) {
        return Math.pow(x, n) * (1 + n);
    }

    public static double calculateFunctionValue(double x) {
        return 1 / Math.pow((1 - x), 2);
    }

    public static void printResult(String phrase, double result) {
        System.out.printf("%s = %f\n", phrase, result);
    }

    public static void printEpsilonRelatedResult(String phrase, RowCalculateResult rowCalculateResult) {
        System.out.println("The sum of the terms of the given sequence greater than epsilon " + phrase + rowCalculateResult.getSum() +
                ". Total " + rowCalculateResult.getIteration() + " term of elements.");
    }
}

