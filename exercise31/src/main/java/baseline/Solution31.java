/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.util.Scanner;

public class Solution31 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int age, restingHeartRate;
        age = getIntInput("What is your age? ");
        restingHeartRate = getIntInput("What is your resting heart rate? ");

        targetHeartRateTable(age, restingHeartRate);
    }

    static void targetHeartRateTable(int age, int restingHR) {
        System.out.printf("Resting Pulse: %d\tAge: %d%n%n", restingHR, age);
        System.out.printf("%-12s | Rate%n-------------|--------%n", "Intensity");

        for (int i = 55; i <= 95; i += 5) {
            String format = i + "%";
            System.out.printf("%-12s | %d bpm%n", format, karvonenCalculate(age, restingHR, i));
        }
    }

    public static int karvonenCalculate(int age, int restingHR, int intensity) {
        return (int)Math.round((((220 - age) - restingHR) * (intensity/100.0)) + restingHR);
    }

    public static int getIntInput(String message) {
        System.out.print(message);
        return validateIntInput(input.nextLine(), message);
    }

    private static int validateIntInput(String in, String message) {
        try {
            return Integer.parseInt(in);
        } catch (Exception e) {
            System.out.println("Input must be an Integer!");
            System.out.print(message);
            return validateIntInput(input.nextLine(), message);
        }
    }
}
