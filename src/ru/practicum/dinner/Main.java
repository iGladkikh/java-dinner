package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner;
    static MenuBuilder menuBuilder;
    static DinnerConstructor dinnerConstructor;

    public static void main(String[] args) {
        menuBuilder = new MenuBuilder();
        dinnerConstructor = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombos();
                    printDishCombos();
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

        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        if (menuBuilder.hasDish(dishName)) {
            System.out.println("Блюдо \"" + dishName + "\" уже содержится в списке");
            return;
        }

        // добавьте новое блюдо
        menuBuilder.addDish(dishType, dishName);
        System.out.println("Блюдо \"" + dishName + "\" добавлено в категорию " + "\"" + dishType + "\"");
    }

    private static void generateDishCombos() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        String line = scanner.nextLine();
        int combosCount = StringReader.isPositiveNumber(line)
                ? Integer.parseInt(line)
                : getPositiveNumber(line);
        dinnerConstructor.setCombosCount(combosCount);

        System.out.println("Введите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        System.out.println("допустимые варианты - " + menuBuilder.getCategories());

        dinnerConstructor.clearCategories();
        while (true) {
            String category = scanner.nextLine();
            if (!menuBuilder.hasCategory(category)) {
                category = getCorrectDishCategory(category);
            }
            if (category.isEmpty()) {
                break;
            }
            dinnerConstructor.addCategory(category);
        }

        dinnerConstructor.generateCombos(menuBuilder.getMenu());
    }

    private static void printDishCombos() {
        ArrayList<ArrayList<String>> combos = dinnerConstructor.getCombos();
        int i = 1;
        for (ArrayList<String> combo : combos) {
            System.out.println("Комбо " + (i++));
            System.out.println(combo);
        }
    }

    private static String getCorrectDishCategory(String value) {
        while (value.isEmpty() || !menuBuilder.hasCategory(value)) {
            if (value.isEmpty()) {
                return "";
            }

            System.out.println("Введено неверное значение - " + value);
            System.out.println("Введите корректное значение типа блюда");
            value = scanner.nextLine();
        }
        return value;
    }

    private static int getPositiveNumber(String value) {
        while (!StringReader.isPositiveNumber(value)) {
            System.out.println("Введено неверное значение - " + value);
            System.out.println("Введите положительное число");
            value = scanner.nextLine();
        }
        return Integer.parseInt(value);
    }
}