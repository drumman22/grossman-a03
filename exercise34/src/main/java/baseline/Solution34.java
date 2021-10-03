/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution34 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> employees = new LinkedList<>(Arrays.asList("John Smith", "Jackie Jackson", "Chris Jones", "Amanda Cullen", "Jeremy Goodwin"));
        printEmployees(employees);

        System.out.print("\nEnter an employee name to remove: ");
        String pickEmployee = input.nextLine();

        employees.removeIf(pickEmployee::equalsIgnoreCase);
        printEmployees(employees);
    }

    public static void printEmployees(List<String> list) {
        System.out.printf("There are %d employees:%n", list.size());
        for (String employee: list) {
            System.out.println(employee);
        }
    }
}
