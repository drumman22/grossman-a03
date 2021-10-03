/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution35 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        List<String> players = new ArrayList<>();
        String name;

        while(true) {
            name = getInput("Enter a name: ");
            if (name.isEmpty())
                break;

            players.add(name);
        }

        String winner = players.get(random.nextInt(players.size()));
        System.out.printf("The winner is... %s!", winner);
    }

    public static String getInput(String message) {
        System.out.print(message);
        return input.nextLine();
    }
}
