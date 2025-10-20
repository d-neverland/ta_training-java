package com.epam.training.dariia_binevych.meet_a_stranger_ex;

import java.util.Scanner;

public class MeetAStranger {
    public static void main(String[] args) {

        Scanner stranger = new Scanner(System.in);
        String greeting = stranger.nextLine();

        System.out.println("Hello, " + greeting);
    }
}
