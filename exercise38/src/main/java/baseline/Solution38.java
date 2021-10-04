/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution38 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a list of numbers, seperated by spaces: ");
        List<Integer> list = parseNums(input.nextLine());

        List<Integer> evens = filterEvenNumbers(list);
        System.out.print("The even numbers are ");
        printList(evens);
    }

    public static <E> void printList(List<E> list) {
        for (E element: list) {
            System.out.print(element + " ");
        }
    }

    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        for (Integer number: numbers) {
            if (number % 2 == 0)
                evens.add(number);
        }

        return evens;
    }

    public static List<Integer> parseNums(String numbers) {
        List<Integer> nums = new ArrayList<>();
        String[] numArr = numbers.split("[^\\d]+");

        for (int i = 0; i < numArr.length; i++) {
            nums.add(Integer.parseInt(numArr[i]));
        }

        return nums;
    }
}
