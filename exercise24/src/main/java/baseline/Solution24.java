/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.util.Arrays;
import java.util.Scanner;

public class Solution24 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1, str2;

        System.out.print("Enter to strings and I'll tell you if they are anagrams:\nEnter the first string: ");
        str1 = input.nextLine();

        System.out.print("Enter the second string: ");
        str2 = input.nextLine();

        System.out.printf("\"%s\" and \"%s\" are%s anagrams.", str1, str2, isAnagram(str1, str2) ? "" : " not");
    }

    private static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();

        // Sort and then check if arrays are the same
        Arrays.sort(str1Arr);
        Arrays.sort(str2Arr);
        return Arrays.equals(str1Arr, str2Arr);
    }
}
