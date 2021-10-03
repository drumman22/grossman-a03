/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.security.SecureRandom;
import java.util.Scanner;

public class Solution32 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom(); // only create once

        System.out.print("Let's play Guess the Number!\n\n");
        gameLoop(random); // Main loop
    }

    public static void gameLoop(SecureRandom random) {
        int randInt = randomInt(random,1, getDifficulty());
        int guesses = 1;

        int guessedNumber = getIntInput("I have my number. What's your guess? ");
        while (guessedNumber != randInt) {
            String hint = "Too low. ";
            if (guessedNumber > randInt)
                hint = "Too high. ";

            String format = hint + "Guess again: ";
            guessedNumber = getIntInput(format);
            guesses++;
        }

        System.out.printf("You got it in %d guesses!%n%n", guesses);

        // End game unless user wants to play again
        if (getBoolInput("Do you wish to play again? (Y/N)? "))
            gameLoop(random);
    }

    public static int randomInt(SecureRandom random, int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    // Get the difficulty for the game
    public static int getDifficulty() {
        int difficulty = getIntInput("Enter the difficulty level (1, 2, or 3): ");
        return (int)Math.pow(10, difficulty);
    }

    // Get boolean input using Y or N
    public static boolean getBoolInput(String message) {
        System.out.print(message);
        return validateBoolInput(input.nextLine(), message);
    }

    private static boolean validateBoolInput(String in, String message) {
        if (in.equalsIgnoreCase("Y"))
            return true;
        if (in.equalsIgnoreCase("N"))
            return false;

        System.out.println("Invalid input!");
        System.out.print(message);
        return validateBoolInput(in, message);
    }

    // Get integer input
    public static int getIntInput(String message) {
        System.out.print(message);
        return validateIntInput(input.nextLine(), message);
    }

    private static int validateIntInput(String in, String message) {
        try {
            return Integer.parseInt(in);
        } catch (Exception e) {
            System.out.println("Input must be an integer!");
            System.out.print(message);
            return validateIntInput(input.nextLine(), message);
        }
    }
}
