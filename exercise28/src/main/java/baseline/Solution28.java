/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */


package baseline;

import java.util.Scanner;

public class Solution28 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int sum = getSum(5);
        System.out.printf("The total is %d.", sum);
    }

    public static int getSum(int num) {
        int sum = 0;
        for (int i = 0; i < num; i++) {
            System.out.print("Enter a number: ");
            sum += Integer.parseInt(input.nextLine());
        }

        return sum;
    }
}
