/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.security.SecureRandom;
import java.util.Scanner;

public class Solution37 {
    static Scanner input = new Scanner(System.in);
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] numbers = "0123456789".toCharArray();
    private static final char[] special = "!@#$%^&*()<>?".toCharArray();
    private static final char[][] collection = {alphabet, numbers, special};

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        // Get input
        int minLen = getIntInput("What's the minimum length? ");
        int requiredSpecials = getIntInput("How many special characters? ");
        int requirdNums = getIntInput("How many numbers? ");

        String password = generatePassword(random, minLen, requirdNums, requiredSpecials);
        System.out.printf("Your password is %s", password);
    }

    private static String generatePassword(SecureRandom random, int minLen, int requiredNums, int requiredSpec) {
        StringBuilder password = new StringBuilder();
        int minLetters = requiredNums + requiredNums;
        int[] counts = {minLetters, requiredNums, requiredSpec};

        // Loop until requirements filled
        while (password.length() < minLen || counts[0] > 0 || counts[1] > 0 || counts[2] > 0) {
            int category = pickCategory(random, counts);
            password.append(getRandomChar(random, collection[category]));
            counts[category]--;
        }

        return password.toString();
    }

    private static int pickCategory(SecureRandom random, int[] counts) {
        if (counts[1] == 0 && counts[2] == 0)
            return 0;

        int category;
        do {
            category = random.nextInt(collection.length);
        } while (counts[category] == 0); // pick another category if requirement fulfilled

        return category;
    }

    private static char getRandomChar(SecureRandom random, char[] chars) {
        return chars[random.nextInt(chars.length)];
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
