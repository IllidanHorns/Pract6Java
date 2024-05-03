package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int choice = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (choice != 2 && choice != 1)
        {
            System.out.println("Выберите роль: ");
            System.out.println("1. Принцесса");
            System.out.println("2. Слуга");
            try
            {
                choice = scanner.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Неправильный ввод!");
                scanner.next();
            }
        }

        if (choice == 1)
        {
            Pricess pricess = new Pricess();
            pricess.getDresses().dress_actions();
        }
        else if (choice == 2)
        {
            Servant servant = new Servant();
            servant.getFlowers().flowers_actions();
        }
    }
}