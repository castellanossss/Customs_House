package view;

import java.util.Scanner;

public class Menus {
    private Scanner scanner; 

    public Menus() {
        scanner = new Scanner(System.in);
    }

    public String showFirstMenu() {
        System.out.println("+---------------------------------+");
        System.out.println("|            WELCOME TO           |");
        System.out.println("|      MELBOURNE CUSTOMS HOUSE    |");
        System.out.println("+---------------------------------+");
        System.out.println("|        AVAILABLE OPTIONS        |");
        System.out.println("+---------------------------------+");
        System.out.println("| 1. Register an Import           |");
        System.out.println("| 2. Register an Export           |");
        System.out.println("| 3. Advanced Options             |");
        System.out.println("| 4. Exit                         |");
        System.out.println("+---------------------------------+");
        System.out.print("Enter your option: ");
        return scanner.next();
    }

    public String showSecondMenu() {
        System.out.println("+---------------------------------+");
        System.out.println("|         ADVANCED OPTIONS        |");
        System.out.println("+---------------------------------+");
        System.out.println("|          MOVEMENT INFO          |");
        System.out.println("+---------------------------------+");
        System.out.println("| 1. Filter by date               |");
        System.out.println("| 2. Filter by imports            |");
        System.out.println("| 3. Filter by exports            |");
        System.out.println("| 4. Filter by identification     |");
        System.out.println("| 5. Show movements history       |");
        System.out.println("| 6. Show movement info           |");
        System.out.println("| 7. Generate Serialized File     |");
        System.out.println("| 8. Back to main menu            |");
        System.out.println("| 9. Exit                         |");
        System.out.println("+---------------------------------+");
        System.out.print("Enter your option: ");
        return scanner.next();
    }

    public String showThirdMenu() {
        System.out.println("+---------------------------------+");
        System.out.println("|        FINISHED PROCESSES       |");
        System.out.println("+---------------------------------+");
        System.out.println("|        AVAILABLE OPTIONS        |");
        System.out.println("+---------------------------------+");
        System.out.println("| 1. Back to second menu          |");
        System.out.println("| 2. Exit                         |");
        System.out.println("+---------------------------------+");
        System.out.print("Enter your option: ");
        return scanner.next();
    }

    public void printBorderedMessage(String message) {
        int messageLength = message.length();
        String border = "+" + "-".repeat(messageLength + 2) + "+";
        System.out.println(border);
        System.out.println("| " + message + " |");
        System.out.println(border);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printBorderedTitleMessage() {
        String message = "WELCOME TO MELBOURNE CUSTOMS HOUSE";
        int length = message.length();
        String border = "╔" + "═".repeat(length + 2) + "╗";
        System.out.println(border);
        System.out.println("║ " + message + " ║");
        border = "╚" + "═".repeat(length + 2) + "╝";
        System.out.println(border);
    }

    public void printBorderedTitle(String message) {
        int length = message.length();
        String border = "╔" + "═".repeat(length + 2) + "╗";
        System.out.println(border);
        System.out.println("║ " + message + " ║");
        border = "╚" + "═".repeat(length + 2) + "╝";
        System.out.println(border);
    }

}
