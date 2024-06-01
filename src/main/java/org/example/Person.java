package org.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Person {
    private String Name = null;

    private String Role = null;

    private String protective_pet = null;

    private String method_of_transportation = null;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }


    public String getProtective_pet() {
        return protective_pet;
    }

    public void setProtective_pet(String protective_pet) {
        this.protective_pet = protective_pet;
    }

    public String getMethod_of_transportation() {
        return method_of_transportation;
    }

    public void setMethod_of_transportation(String method_of_transportation) {
        this.method_of_transportation = method_of_transportation;
    }

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

    public Boolean set_the_method_of_transportation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать!");
        System.out.println("На чем вы хотите добраться до замка?");
        System.out.println("1. Лошадь 2. Карета 3. По волшебству");

        int choice = 0;

        try {
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= 3) {
                switch (choice) {
                    case 1:
                        method_of_transportation = "Лошадь";
                        System.out.println("Вы выбрали лошадь, ваш путь будет сложным");
                        myLog.logger.info("Пользователь выбрал способ передвижения - лошадь");
                        return true;
                    case 2:
                        method_of_transportation = "Карета";
                        System.out.println("Вы выбрали карету, ваш путь будет легче");
                        myLog.logger.info("Пользователь выбрал способ передвижения - карета");
                        return true;
                    case 3:
                        method_of_transportation = "Волшебство";
                        System.out.println("Вы выбрали по волшебству, ваш путь будет волшебным");
                        myLog.logger.info("Пользователь выбрал способ передвижения - волшебство");
                        return true;
                }
            } else {
                myLog.logger.warning("Пользователь ввёл несуществующий пункт выбора способа передвижения!");
                System.out.println("Выберите число от 1 до 3. Попробуйте снова.");
                return false;
            }
        } catch (InputMismatchException e) {
            myLog.logger.warning("Неправильный ввод пункта выбора для средства передвижения!");
            System.out.println("Ошибка ввода. Попробуйте снова.");
            method_of_transportation = "Пешочком";
            scanner.next(); // Очистить неверный ввод
            return false;
        }
        return false;
    }

    public Boolean set_the_protective_pet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать!");
        System.out.println("Выберите своё животное для защиты!");
        System.out.println("1. Кот 2. Бык 3. Лев 4. Собака");
        int choice = 0;

        System.out.println("Введите число от 1 до 4:");
        try {
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= 4) {
                switch (choice) {
                    case 1:
                        protective_pet = "Кот";
                        System.out.println("Вы выбрали для охраны кота");
                        myLog.logger.info("Пользователь выбрал питомца - кот");
                        return true;
                    case 2:
                        protective_pet = "Бык";
                        System.out.println("Вы выбрали для охраны быка");
                        myLog.logger.info("Пользователь выбрал питомца - бык");
                        return true;
                    case 3:
                        protective_pet = "Лев";
                        System.out.println("Вы выбрали для охраны льва");
                        myLog.logger.info("Пользователь выбрал питомца - лев");
                        return true;
                    case 4:
                        protective_pet = "Собака";
                        System.out.println("Вы выбрали для охраны собаку");
                        myLog.logger.info("Пользователь выбрал питомца - собака");
                        return true;
                }
            } else {
                myLog.logger.warning("Пользователь ввёл несуществующий пункт выбора питомца!");
                System.out.println("Выберите число от 1 до 4. Попробуйте снова.");
                return false;
            }
        } catch (InputMismatchException e) {
            myLog.logger.warning("Неправильный ввод пункта выбора для питомца!");
            System.out.println("Ошибка ввода. Попробуйте снова.");
            protective_pet = "Нет";
            scanner.next(); // Очистить неверный ввод
            return false;
        }
        return false;
    }

    public Boolean set_the_name() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Напишите своё имя - ");
        String name;
        name = scanner.next();
        if (name.isEmpty()) {
            myLog.logger.warning("Пользователь ввёл имя пустым!");
            System.out.println("Ваше имя не должно быть пустым!");
        } else {
            Name = name;
            myLog.logger.info("Пользователь ввел имя - " + name);
            System.out.println("Да здравствует наш - " + Name);
            return true;
        }
        return false;
    }

    public void return_person_param(){};
}
