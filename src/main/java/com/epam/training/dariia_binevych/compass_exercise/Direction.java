package com.epam.training.dariia_binevych.compass_exercise;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    private final int degrees;

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    public static Direction ofDegrees(int degrees) {
        int normalized = ((degrees % 360) + 360) % 360;
        for (Direction d : values()) {
            if (d.degrees == normalized) {
                return d;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        int normalized = ((degrees % 360) + 360) % 360;
        Direction closest = null;
        int minDiff = Integer.MAX_VALUE;
        for (Direction d : values()) {
            int diff = Math.abs(d.degrees - normalized);
            diff = Math.min(diff, 360 - diff);
            if (diff < minDiff) {
                minDiff = diff;
                closest = d;
            }
        }
        return closest;
    }

    public Direction opposite() {
        int oppositeDeg = (degrees + 180) % 360;
        return ofDegrees(oppositeDeg);
    }

    public int differenceDegreesTo(Direction direction) {
        int diff = Math.abs(this.degrees - direction.degrees);
        return Math.min(diff, 360 - diff);
    }
}
