package com.epam.training.dariia_binevych.electronic_watch_exercise;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();

        int hours = (seconds / 3600) % 24;
        int minutes = (seconds / 60) % 60;
        int secs = seconds % 60;

        System.out.println(hours + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", secs));


    }
}
