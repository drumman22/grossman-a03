/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.util.Random;
import java.util.Scanner;

public class Solution32 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Let's play Guess the Number!\n\n");
        gameLoop();
    }

    public static void gameLoop() {
        int randInt = randomInt(1, getDificulty());
        int guessedNumber = -1;
        int guesses = 1;

        guessedNumber = getIntInput("I have my numnber. What's your guess? ");
        while (guessedNumber != randInt) {
            String hint = "Too low. ";
            if (guessedNumber > randInt)
                hint = "Too high. ";

            String format = hint + "Guess again: ";
            guessedNumber = getIntInput(format);
            guesses++;
        }

        System.out.printf("You got it in %d guesses!%n%n", guesses);
        if (getBoolInput("Do you wish to play again? (Y/N)? "))
            gameLoop();
    }

    public static int randomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int getDificulty() {
        int difficulty = getIntInput("Enter the difficulty level (1, 2, or 3): ");
        return (int)Math.pow(10, difficulty);
    }

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
