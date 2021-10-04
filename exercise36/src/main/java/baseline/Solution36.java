/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution36 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        // input
        getNumbers(numbers);

        // output
        printNumbers(numbers);
        printNumberStats(numbers);
    }

    public static void getNumbers(List<Integer> nums) {
        while(true) {
            String number = getInput("Enter a number: ");
            if (number.equalsIgnoreCase("done"))
                break;

            nums.add(validateIntInput(number, "Enter a number: "));
        }
    }

    public static void printNumbers(List<Integer> nums) {
        System.out.print("Numbers: ");
        for (Integer number: nums) {
            System.out.printf(" %d,", number);
        }
        System.out.println();
    }

    public static void printNumberStats(List<Integer> nums){
        System.out.printf("The average is %.1f%n", average(nums));
        System.out.printf("The minimum is %d%n", min(nums));
        System.out.printf("The maximum is %d%n", max(nums));
        System.out.printf("The standard deviation is %.2f", std(nums));
    }

    public static double average(List<Integer> nums) {
        int avg = 0;
        for (Integer num : nums) {
            avg += num;
        }
        return avg/(double)nums.size();
    }

    public static double averageDouble(List<Double> nums) {
        int avg = 0;
        for (Double num : nums) {
            avg += num;
        }
        return avg/(double)nums.size();
    }

    public static int max(List<Integer> nums) {
        int max = Integer.MIN_VALUE;
        for (Integer num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int min(List<Integer> nums) {
        int min = Integer.MAX_VALUE;
        for (Integer num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static double std(List<Integer> nums) {
        List<Double> sqrDifferences = new ArrayList<>();
        Double avg = average(nums);
        for (Integer number: nums) {
            sqrDifferences.add(Math.pow((avg - number), 2));
        }

        double variance = averageDouble(sqrDifferences);
        return Math.sqrt(variance);
    }

    public static String getInput(String message) {
        System.out.print(message);
        return input.nextLine();
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