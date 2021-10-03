/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.util.Scanner;

public class Solution26 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        double balance, apr, monthlyPayment;
        PaymentCalculator calculator = new PaymentCalculator();

        System.out.print("What is your balance? ");
        balance = Double.parseDouble(input.nextLine());
        System.out.print("What is the APR on the card (as a percent)? ");
        apr = Double.parseDouble(input.nextLine());
        System.out.print("What is the monthly payment you can make? ");
        monthlyPayment = Double.parseDouble(input.nextLine());

        System.out.printf("It will take you %d months to pay off this card.", calculator.calculateMonthsUntilPaidOff(balance, monthlyPayment, apr));
    }
}
