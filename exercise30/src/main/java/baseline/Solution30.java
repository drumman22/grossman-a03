/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

public class Solution30 {
    public static void main(String[] args) {
        createTable(12);
    }

    public static void createTable(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                System.out.printf("%5d", i * j);
            }
            System.out.println();
        }
    }
}
