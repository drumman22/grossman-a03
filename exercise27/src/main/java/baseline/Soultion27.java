package baseline;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Soultion27 {
    public static void main(String[] args) {
        String firstName, lastName, zip, id;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first name: ");
        firstName = in.nextLine();
        System.out.print("Enter the last name: ");
        lastName = in.nextLine();
        System.out.print("Enter the ZIP code: ");
        zip = in.nextLine();
        System.out.print("Enter the employee ID: ");
        id = in.nextLine();

        if (validateInput(firstName, lastName, zip, id))
            System.out.println("There were no errors found.");
    }

    public static boolean validateInput(String firstName, String lastName, String zip, String id) {
        boolean validation = validateName(firstName, "first");

        if (!validateName(lastName, "last")) {
            validation = false;
        }

        if (!validateZipCode(zip)) {
            validation = false;
        }

        if (!validateEmployeeID(id)) {
            validation = false;
        }

        return validation;

    }

    public static boolean validateName(String name, String prefix) {
        if (name.length() < 2) {
            System.out.printf("The %s name must be at least 2 characters long.%n", prefix);

            if (name.length() == 0)
                System.out.printf("The %s name must be filled in.%n", prefix);

            return false;
        }
        return true;
    }

    public static boolean validateZipCode(String zip) {
        Pattern p = Pattern.compile("^[0-9]+$");
        Matcher m = p.matcher(zip);

        if (zip.length() != 5 || !m.find()) {
            System.out.println("The zipcode must be a 5 digit number.");
            return false;
        }

        return true;
    }

    public static boolean validateEmployeeID(String id) {
        Pattern p = Pattern.compile("^[a-zA-Z]{2}-[0-9]{4}$");
        Matcher m = p.matcher(id);

        if (!m.find()) {
            System.out.println("The employee ID must be in the format of AA-1234.");
            return false;
        }

        return true;
    }
}
