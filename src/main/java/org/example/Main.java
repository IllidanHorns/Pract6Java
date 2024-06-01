package org.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Log myLog;

    static {
        try{
            myLog = new Log("logger.log");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    static int choice = -1;
    public static void main(String[] args) throws IOException {
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
                myLog.logger.warning("Неправильный ввод пункта выбора!");
            }
        }
        if (choice == 1)
        {
            myLog.logger.info("Пользователь выбрал играть за прицессу");
            Pricess pricess = new Pricess();
            pricess.getDresses().dress_actions();
        }
        else if (choice == 2) {
            myLog.logger.info("Пользователь выбрал играть за слугу");
            Servant servant = new Servant();
            servant.getFlowers().flowers_actions();
        }
    }
}