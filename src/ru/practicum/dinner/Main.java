package ru.practicum.dinner;

import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static MenuBuilder menu = new MenuBuilder();

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        if (!menu.hasCategory(dishType)) {
            System.out.println("Тип блюда \"" + dishType + "\" отсутствует");
            return;
        }

        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        if (menu.hasDish(dishName)) {
            System.out.println("Блюдо \"" + dishName + "\" уже содержится в списке");
            return;
        }

        // добавьте новое блюдо
        menu.addDish(dishType, dishName);
        System.out.println("Блюдо добавлено");
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {

        }

        // сгенерируйте комбинации блюд и выведите на экран

    }
}