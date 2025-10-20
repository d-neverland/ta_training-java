package com.epam.training.dariia_binevych.classes_exercise;

import java.util.Arrays;

public class ArrayRectangles {

    private final Rectangle[] rectangleArray;

    public ArrayRectangles(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        rectangleArray = new Rectangle[size];
    }

    public ArrayRectangles(Rectangle... rectangles) {
        if (rectangles == null || rectangles.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        rectangleArray = Arrays.copyOf(rectangles, rectangles.length);

    }

    public boolean addRectangle(Rectangle rectangle) {
        if (rectangle == null) {
            throw new IllegalArgumentException("Rectangle must not be empty");
        }

        for (int i = 0; i < rectangleArray.length; i++) {
            if (rectangleArray[i] == null) {
                rectangleArray[i] = rectangle;
                return true;
            }
        }
        return false;
    }

    public int size() {
        int count = 0;
        for (Rectangle rectangle : rectangleArray) {
            if (rectangle != null) {
                count++;
            }
        }
        return count;
    }

    public int indexMaxArea() {
        if (size() == 0) {
            return -1;
        }

        int maxIndex = -1;
        double maxArea = Double.MIN_VALUE;

        for (int i = 0; i < rectangleArray.length; i++) {
            Rectangle rectangle = rectangleArray[i];
            if (rectangle != null) {
                double area = rectangle.area();
                if (area > maxArea) {
                    maxArea = area;
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }

    public int indexMinPerimeter() {
        if (size() == 0) {
            return -1;
        }

        int minIndex = -1;
        double minArea = Double.MAX_VALUE;

        for (int i = 0; i < rectangleArray.length; i++) {
            Rectangle rectangle = rectangleArray[i];
            if (rectangle != null) {
                double area = rectangle.area();
                if (area < minArea) {
                    minArea = area;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    public int numberSquares() {
        int count = 0;

        for (Rectangle rectangle : rectangleArray) {
            if (rectangle != null && rectangle.isSquare()) {
                count++;
            }
        }
        return count;
    }
}
