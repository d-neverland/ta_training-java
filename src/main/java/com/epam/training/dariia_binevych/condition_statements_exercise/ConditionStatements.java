package com.epam.training.dariia_binevych.condition_statements_exercise;


class ConditionStatements {

    public static int task1(int n) {

        if (n > 0) {
            return n * n;
        }
        if (n < 0) {
            return Math.abs(n);
        }
        return 0;
    }
}
