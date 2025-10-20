package com.epam.training.dariia_binevych.find_maximum_exercise;

class ConditionStatements {

    public static int task2(int n) {

        int digit1 = n / 100;
        int digit2 = (n / 10) % 10;
        int digit3 = n % 10;

        int[] digits = {digit1, digit2, digit3};
        java.util.Arrays.sort(digits);
        return digits[2] * 100 + digits[1] * 10 + digits[0];

    }
}
