package com.epam.training.dariia_binevych.exceptions_exercise;

public class Matrix {

    private final double[][] data;
    private final int rows;
    private final int cols;

    public Matrix(int rows, int cols) throws MatrixException {
        if (rows < 1 || cols < 1) {
            throw new MatrixException("Rows and columns must be >= 1");
        }
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public Matrix(double[][] values) throws MatrixException {
        if (values == null || values.length == 0 || values[0].length == 0) {
            throw new MatrixException("Invalid matrix dimensions");
        }
        this.rows = values.length;
        this.cols = values[0].length;
        for (double[] row : values) {
            if (row.length != this.cols) {
                throw new MatrixException("Inconsistent row sizes");
            }
        }
        this.data = values;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return cols;
    }

    public double get(int row, int col) throws MatrixException {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new MatrixException("Index out of bounds");
        }
        return data[row][col];
    }

    public void set(int row, int col, double value) throws MatrixException {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new MatrixException("Index out of bounds");
        }
        data[row][col] = value;
    }

    public double[][] toArray() {
        return data;
    }

    public Matrix add(Matrix other) throws MatrixException {
        if (other.rows != this.rows || other.cols != this.cols) {
            throw new MatrixException("Matrices must have the same dimensions for addition");
        }
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix subtract(Matrix other) throws MatrixException {
        if (other.rows != this.rows || other.cols != this.cols) {
            throw new MatrixException("Matrices must have the same dimensions for subtraction");
        }
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) throws MatrixException {
        if (this.cols != other.rows) {
            throw new MatrixException("Number of columns of first matrix must equal number of rows of second");
        }
        double[][] result = new double[this.rows][other.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                result[i][j] = sum;
            }
        }
        return new Matrix(result);
    }
}
