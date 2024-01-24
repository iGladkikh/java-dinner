package ru.practicum.dinner;

import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static MenuBuilder menu;

    public static void main(String[] args) {
        menu = new MenuBuilder();
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
        System.out.println("Блюдо \"" + dishName + "\" добавлено в категорию " + "\"" + dishName + "\"");
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        String inputData = scanner.nextLine();
        int numberOfCombos = StringReader.getPositiveInt(inputData);
        if (numberOfCombos < 1) {
            System.out.println("введено неверное значение - " + inputData);
            return;
        }

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        System.out.println(menu.getMenu().keySet());
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            if (menu.hasCategory(nextItem)) {
                dc.addCategory(nextItem);
            }
        }

        // сгенерируйте комбинации блюд и выведите на экран

    }
}