package com.epam.training.dariia_binevych.sumfibonaccinumbers_exercise;


class LoopStatements {
    public static int sumOfFibonacciNumbers(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        int a = 0;
        int b = 1;
        int sum = a + b;

        if (n == 1) return a;
        if (n == 2) return sum;

        for (int i = 3; i <= n; i++) {
            int next = a + b;
            sum += next;
            a = b;
            b = next;
        }
        return sum;
    }
}
