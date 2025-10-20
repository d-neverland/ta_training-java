package com.epam.training.dariia_binevych.function_task02_exercise;

public class FunctionsTask2 {
    public static boolean isSorted(int[] array, SortOrder order) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        for (int i = 0; i < array.length; i++) {
            if (i == 0) continue;
            if (order == SortOrder.ASC) {
                if (array[i - 1] > array[i]) {

                    return false;
                }
            } else if (order == SortOrder.DESC) {
                if (array[i - 1] < array[i]) {
                    return false;
                }
            }

        }
        return true;
    }

    public static int[] transform(int[] array, SortOrder order) {

        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        if (!isSorted(array, order)) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + i;
        }
        return array;
    }
}

