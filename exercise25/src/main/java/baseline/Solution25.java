/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password;
        int strength;

        System.out.print("Enter your password: ");
        password = input.nextLine();

        strength = passwordValidator(password);
        System.out.printf("The password '%s' is a %s password.", password, passwordStrength(strength));
    }

    public static String passwordStrength(int v) {
        return switch (v) {
            case 0 -> "very weak";
            case 1 -> "weak";
            case 2 -> "strong";
            case 3 -> "very strong";
            default -> "unknown strength";
        };
    }

    private static int passwordValidator(String password) {
        Matcher letters = Pattern.compile("[A-Za-z]").matcher(password);
        Matcher numbers = Pattern.compile("[0-9]").matcher(password);
        Matcher special = Pattern.compile("[^A-Za-z0-9]").matcher(password);

        boolean hasSpecial = special.find();
        boolean hasLetters = letters.find();
        boolean hasNumbers = numbers.find();
        int passwordLen = password.length();

        if ((hasNumbers && passwordLen < 8) && (!hasLetters && !hasSpecial))
            return 0;
        if ((hasLetters && passwordLen < 8) && (!hasNumbers && !hasSpecial))
            return 1;
        if ((hasLetters && hasNumbers && passwordLen >= 8) && !hasSpecial)
            return 2;
        if (hasLetters && hasNumbers && hasSpecial && passwordLen >= 8)
            return 3;

        return -1;
    }
}
