package com.epam.training.dariia_binevych.classes_exercise;

import java.util.Objects;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle() {
        sideA = 4;
        sideB = 3;
    }

    public Rectangle(double sideA, double sideB) {
        if (sideA <= 0 || sideB <= 0) {
            throw new IllegalArgumentException("Sides must be greater than zero");
        }
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be greater than zero");
        }
        this.sideA = side;
        this.sideB = side;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double area() {
        return sideA * sideB;
    }

    public double perimeter() {
        return 2 * (sideA + sideB);
    }

    public boolean isSquare() {
        return sideA == sideB;
    }

    public void replaceSides() {
        double temp;
        temp = sideA;
        sideA = sideB;
        sideB = temp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(sideA, rectangle.sideA) == 0 && Double.compare(sideB, rectangle.sideB) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                '}';
    }


}


