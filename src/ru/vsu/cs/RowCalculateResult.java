package ru.vsu.cs;

public class RowCalculateResult {
    int iteration;
    double sum;

    public RowCalculateResult(int iteration, double sum) {
        this.iteration = iteration;
        this.sum = sum;
    }

    public int getIteration() {
        return iteration;
    }

    public double getSum() {
        return sum;
    }
}
