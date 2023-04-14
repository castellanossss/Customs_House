package view;

import java.util.Scanner;

public class MovementView {
    private Scanner scanner;

    public MovementView() {
        scanner = new Scanner(System.in);
    }

    public void printBorderedTitleMessage() {
        String message = "Movement Registration";
        int length = message.length();
        String border = "╔" + "═".repeat(length + 2) + "╗";
        System.out.println(border);
        System.out.println("║ " + message + " ║");
        border = "╚" + "═".repeat(length + 2) + "╝";
        System.out.println(border);
    }

    public String requestInfo(String info) {
        System.out.print(info);
        return scanner.next();
    }

    public void printBorderedMessage(String message) {
        int length = message.length();
        String border = "╔" + "═".repeat(length + 2) + "╗";
        System.out.println(border);
        System.out.println("║ " + message + " ║");
        border = "╚" + "═".repeat(length + 2) + "╝";
        System.out.println(border);
    }

    public String showOriginCountryMenu() {
        System.out.println("+---------------------------------+");
        System.out.println("|     SELECT COUNTRY OF ORIGIN    |");
        System.out.println("+---------------------------------+");
        System.out.println("| 1. Germany                      |");
        System.out.println("| 2. Sweden                       |");
        System.out.println("| 3. Japan                        |");
        System.out.println("| 4. Brazil                       |");
        System.out.println("| 5. Iceland                      |");
        System.out.println("+---------------------------------+");
        System.out.print("Enter your option: ");
        return scanner.next();
    }

    public String showDestinationCountryMenu() {
        System.out.println("+----------------------------------+");
        System.out.println("|    SELECT DESTINATION COUNTRY    |");
        System.out.println("+----------------------------------+");
        System.out.println("| 1. Germany                       |");
        System.out.println("| 2. Sweden                        |");
        System.out.println("| 3. Japan                         |");
        System.out.println("| 4. Brazil                        |");
        System.out.println("| 5. Iceland                       |");
        System.out.println("+----------------------------------+");
        System.out.print("Enter your option: ");
        return scanner.next();
    }

    
    public void printBorderedCustomMessage(String message, String type) {
        String message2 = type + " " + message;
        int messageLength = message2.length();
        String border = "+" + "-".repeat(messageLength + 2) + "+";
        System.out.println(border);
        System.out.println("| " + message2 + " |");
        System.out.println(border);
    }

}
