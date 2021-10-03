/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.util.Scanner;

public class Solution29 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int rate = getIntInput("What is the rate of return? ");
        System.out.printf("It will take %d years to double your initial investment", 72/rate);
    }

    public static int getIntInput(String message) {
        System.out.print(message);
        return validateIntInput(input.nextLine(), message);
    }

    private static int validateIntInput(String in, String message) {
        try {
            int response = Integer.parseInt(in);
            if (response == 0) throw new InvalidIntegerInput("Input cannot be 0");

            return response;
        } catch (Exception e) {
            System.out.println("Sorry. That's not a valid input.");
            System.out.print(message);
            return validateIntInput(input.nextLine(), message);
        }
    }
}
