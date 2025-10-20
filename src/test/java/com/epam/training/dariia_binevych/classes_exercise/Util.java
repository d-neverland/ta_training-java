package com.epam.training.dariia_binevych.classes_exercise;

import java.util.Random;

public class Util {
    static double nextDouble(Random r, double origin, double bound) {
        return r.nextDouble() * (bound - origin) + origin;
    }
}
