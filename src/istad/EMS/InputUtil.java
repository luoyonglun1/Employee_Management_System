package istad.EMS;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static String getText(String label) {
        System.out.print(label);
        return scanner.nextLine();
    }

    public static String getTextOnly(String label) {
        String input;
        while (true) {
            System.out.print(label);
            input = scanner.nextLine().trim();
            if (!input.matches("\\d+")) {
                return input;
            }
            System.out.println("Invalid input. Please enter text only, not numbers.");
        }
    }


    public static Integer getInteger(String label) {
        do {
            try {
                System.out.print(label);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static Double getDouble(String label) {
        do {
            try {
                System.out.print(label);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
