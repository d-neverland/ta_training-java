package com.epam.training.dariia_binevych.maximum_distance_exercise;

public class IntArrayUtil {

    public static int maximumDistance(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int firstIndex = -1;
        int lastIndex = -1;

        for (int i = 0; i < array.length; i++) {
            int v = array[i];
            if (v > max) {
                max = v;
                firstIndex = i;
                lastIndex = i;
            } else if (v == max) {
                lastIndex = i;
            }
        }
        return lastIndex - firstIndex;
    }

    public static void main(String[] args) {
        {
            int[] array = null;
            System.out.println("result = " + maximumDistance(array));
        }
        {
            int[] array = new int[]{};
            System.out.println("result = " + maximumDistance(array));
        }
        {
            int[] array = new int[]{4, 100, 3, 4};
            System.out.println("result = " + maximumDistance(array));
        }
        {
            int[] array = new int[]{5, 50, 50, 4, 5};
            System.out.println("result = " + maximumDistance(array));
        }
        {
            int[] array = new int[]{5, 350, 350, 4, 350};
            System.out.println("result = " + maximumDistance(array));
        }
        {
            int[] array = new int[]{10, 10, 10, 10, 10};
            System.out.println("result = " + maximumDistance(array));
        }
    }

}
