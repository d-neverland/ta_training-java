package com.epam.training.dariia_binevych.transform_matrix_exercise;

import java.util.Arrays;

public class MatrixUtil {

    public static void transformMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        for (int[] row : matrix) {
            if (row == null || row.length != n) {
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    matrix[i][j] = 0;
                } else if (j > i) {
                    matrix[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        {
            int[][] matrix = null;
            transformMatrix(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
        {
            int[][] matrix = {};
            transformMatrix(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
        {
            int[][] matrix = {{}};
            transformMatrix(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
        {
            int[][] matrix = {{}, {}};
            transformMatrix(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
        {
            int[][] matrix = {{2, 3}, {4, 5, 6}};
            transformMatrix(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
        {
            int[][] matrix = {{2, 3}, {4, 5}, {}};
            transformMatrix(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
        {
            int[][] matrix = {{2, 3}, {4, 5}};
            transformMatrix(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
        {
            int[][] matrix = {{2, 4, 3, 3}, {5, 7, 8, 5}, {2, 4, 3, 3}, {5, 7, 8, 5}};
            transformMatrix(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
        {

            int[][] matrix = {{2, 3}, {4, 5}, {6, 7}};
            transformMatrix(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
        {
            int[][] matrix = {{2, 4, 3, 3}, {5, 7, 8, 5}, {2, 4, 3, 3}};
            transformMatrix(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
    }
}
