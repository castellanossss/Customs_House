package view;

import java.util.Scanner;

public class CustomerView {
    private Scanner scanner;

    public CustomerView() {
        scanner = new Scanner(System.in);
    }

    public void printBorderedTitleMessage() {
        String message = "Customer Registration";
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
        int messageLength = message.length();
        String border = "+" + "-".repeat(messageLength + 2) + "+";
        System.out.println(border);
        System.out.println("| " + message + " |");
        System.out.println(border);
    }

}
