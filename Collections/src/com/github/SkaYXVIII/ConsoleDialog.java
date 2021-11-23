package com.github.SkaYXVIII;

import java.util.Scanner;

public class ConsoleDialog {
    private Scanner scanner = new Scanner(System.in);

    public int requestInt(){
        while (true) {
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Nie podałeś numeru!");
            }
        }
    }
}
