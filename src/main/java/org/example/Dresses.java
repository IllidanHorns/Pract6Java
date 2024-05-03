package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dresses {

    Pricess pricess;
    public ArrayList<String> choiced_dresses =new ArrayList<String>();
    public ArrayList<String> choiced_decorations =new ArrayList<String>();
    private String[] dresses = {"Красное", "Синие", "Зелёное", "Розовое", "Белое", "Золотое"};
    private String[] decorations = {"Колье", "Браслет", "Серьги"};

    public Dresses(Pricess _pricess) {
        pricess = _pricess;
    }

    public void choice_the_dress(){
        int dress_choice = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите платье:");
        for (Integer i = 0; i < dresses.length; i++){
            System.out.println(i + ". " + dresses[i] + " платье");
        }
        try
        {
            dress_choice = scanner.nextInt();
            if (dress_choice >=0 && dress_choice < dresses.length)
            {
                choiced_dresses.add(dresses[dress_choice]);
                System.out.println("Добавлено платье - " + dresses[dress_choice]);
                System.out.println("Отличный выбор!");
            }
            else
            {
                System.out.println("Ошибка ввода. Такого платья нет в списке!");
                scanner.next();
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Ошибка ввода. Попробуйте снова.");
            scanner.next();
        }
    }

    public void choice_the_decorations(){
        int decoration_choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите украшение: \n");
        for (Integer i = 0; i < decorations.length; i++){
            System.out.println(i + ". " + decorations[i] + " украшение \n");
        }
        try
        {
            decoration_choice = scanner.nextInt();
            if (decoration_choice >=0 && decoration_choice < decorations.length)
            {
                choiced_decorations.add(decorations[decoration_choice]);
                System.out.println("Добавлено украшение - " + decorations[decoration_choice]);
            }
            else
            {
                System.out.println("Ошибка ввода. Такого украшения нет в списке!");
                scanner.next();
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Ошибка ввода. Попробуйте снова.");
            scanner.next();
        }
    }

    public Integer return_dresses_amount() {
        return choiced_dresses.size();
    }

    public Integer return_decorations_amount(){
        return choiced_decorations.size();
    }

    private void withdraw_all_dresses(){
        for (String i : choiced_dresses)
        {
            System.out.println(i + " платье \n");
        }
    }

    private void withdraw_all_decorations()
    {
        for (String i : choiced_decorations)
        {
            System.out.println(i + " украшение \n");
        }
    }

    public void dress_actions()
    {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0)
        {
            System.out.println("Выберите действие: ");
            System.out.println("1. Выбрать платья");
            System.out.println("2. Выбрать украшения");
            System.out.println("3. Все платья");
            System.out.println("4. Все украшени");
            System.out.println("5. Кол-во платьев");
            System.out.println("6. Кол-во украшений");
            System.out.println("7. Информация о игроке");
            System.out.println("0. Прекратить");
            try
            {
                choice = scanner.nextInt();
                switch (choice)
                {
                    case 1:
                        choice_the_dress();
                        break;
                    case 2:
                        choice_the_decorations();
                        break;
                    case 3:
                        withdraw_all_dresses();
                        break;
                    case 4:
                        withdraw_all_decorations();
                        break;
                    case 5:
                        System.out.println(return_dresses_amount());
                        break;
                    case 6:
                        System.out.println(return_decorations_amount());
                        break;
                    case 7:
                        pricess.return_person_param();
                        break;
                    case 0:
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
                scanner.next(); // Очистить неверный ввод
            }
        }
    }
}
