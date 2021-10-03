/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.security.SecureRandom;
import java.util.Scanner;

public class Solution33 {
    private static final String[] strArr = {"Yes.", "No.", "I don't think so.", "Neither.", "Nothing.", "Maybe someday.", "Try asking again."};
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        askEightBall(random);
    }

    public static void askEightBall(SecureRandom random) {
        System.out.print("What's your question?\n> ");
        input.nextLine();

        System.out.print("\n" + strArr[random.nextInt(7)]);
    }
}
