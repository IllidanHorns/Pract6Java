package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Flowers {
    Servant servant;

    public Flowers(Servant _servant) {
        servant = _servant;
    }

    private ArrayList<String> planted_flowers = new ArrayList<String>();

    private String[] flowers = {"Роза", "Тюльпан", "Гвоздика", "Мимоза"};

    private void plant_the_flower ()
    {
        int flower_choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите цветок, который хотите посадить:");
        for (Integer i = 0; i < flowers.length; i++){
            System.out.println(i + ". " + flowers[i] + " платье");
        }
        try
        {
            flower_choice = scanner.nextInt();
            if (flower_choice >=0 && flower_choice < flowers.length)
            {
                planted_flowers.add(flowers[flower_choice]);
                System.out.println("Посажен цветок - " + flowers[flower_choice]);
                System.out.println("Отличный выбор!");
                switch (flower_choice)
                {
                    case 0:
                        System.out.println("Вы посадили розы, принцесса в восторге");
                        break;
                    case 1:
                        System.out.println("Вы посадили тюльпаны, но принцесса их не любит");
                        break;
                    case 2:
                        System.out.println("Вы посадили гвоздику, принцесса в ярости!!! у нее на них аллергия, вы будете уволены и казнены");
                        break;
                    case 3:
                        System.out.println("Вы посадили мимозу, принцессе все равно на этот цветок");
                        break;
                }
            }
            else
            {
                System.out.println("Ошибка ввода. Такого цветка нет в списке!");
                scanner.next();
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Ошибка ввода. Попробуйте снова.");
            scanner.next();
        }
    }

    private void choice_the_flower_to_action()
    {
        int count = 0;
        int flower_choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите цветок, который хотите посадить:");
        for (Integer i = 0; i < planted_flowers.size() ; i++){
            System.out.println(i + ". " + planted_flowers.get(i) + " цветок");
            count++;
        }
        if (count != 0)
        {
            try
            {
                flower_choice = scanner.nextInt();
                if (flower_choice >=0 && flower_choice < planted_flowers.size())
                {
                    System.out.println("Вы выбрали цветок - " + planted_flowers.get(flower_choice));
                    action_flowers(planted_flowers.get(flower_choice));
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
        else
        {
            System.out.println("Вы не выбрали ни одного цветка!");
        }
    }

    private void action_flowers(String flower)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите способ ухода за цветком " + flower + ":");
        System.out.println("1. Полить цветок");
        System.out.println("2. Облить цветок солнечным светом");
        System.out.println("3. Дать цветку отдохнуть");

        int careChoice = -1;
        System.out.println("Введите число от 1 до 3:");
            try {
                careChoice = scanner.nextInt();
                if (careChoice >= 1 && careChoice <= 3) {
                    switch (careChoice) {
                        case 1:
                            System.out.println("Вы полили цветок " + flower + ". Он рад влаге!");
                            break;
                        case 2:
                            System.out.println("Вы облели цветок " + flower + " солнечным светом. Он вырос и радуется!");
                            break;
                        case 3:
                            System.out.println("Вы дали цветку " + flower + " отдохнуть. Он благодарен за покой!");
                            break;
                        default:
                            System.out.println("Некорректный выбор.");
                    }
                } else {
                    System.out.println("Выберите число от 1 до 3. Попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
                scanner.next(); // Очистить неверный ввод
            }
    }

    public void withdraw_all_flowers()
    {
        System.out.println("Все посаженные цветки: \n");
        for (String i : planted_flowers)
        {
            System.out.println(i + " цветок \n");
        }
    }

    public Integer return_flowers_amount()
    {
        return planted_flowers.size();
    }

   public void flowers_actions() {
       int choice = -1;
       Scanner scanner = new Scanner(System.in);
       while (choice != 0) {
           System.out.println("Выберите действие: ");
           System.out.println("1. Посадить цветы");
           System.out.println("2. Действия с цветами");
           System.out.println("3. Вывести все посаженные цветы");
           System.out.println("4. Кол-во всех цветов");
           System.out.println("5. Информация о игроке");
           System.out.println("0. Прекратить");
           try {
               choice = scanner.nextInt();
               switch (choice) {
                   case 1:
                       plant_the_flower();
                       break;
                   case 2:
                       choice_the_flower_to_action();
                       break;
                   case 3:
                       withdraw_all_flowers();
                       break;
                   case 4:
                       System.out.println(return_flowers_amount());
                       break;
                   case 5:
                       servant.return_person_param();
                       break;
                   case 0:
                       break;
               }
           } catch (InputMismatchException e) {
               System.out.println("Ошибка ввода. Попробуйте снова.");
               scanner.next(); // Очистить неверный ввод
           }
       }
   }
}
