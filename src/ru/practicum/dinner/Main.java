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
                    if (menuBuilder.getMenu().isEmpty()) {
                        System.out.println("Меню пусто. Добавьте новые блюда");
                        break;
                    }
                    generateDishCombos();

                    if (dinnerConstructor.getCategories().isEmpty()) {
                        System.out.println("Не выбраны типы блюда");
                        break;
                    }
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

        if (menuBuilder.addDish(dishType, dishName)) {
            System.out.println("Блюдо \"" + dishName + "\" добавлено в категорию " + "\"" + dishType + "\"");
        } else {
            System.out.println("Ошибка добавления блюда \"" + dishName + "\"");
        }
    }

    private static void generateDishCombos() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        String line = scanner.nextLine();
        int combosCount = isPositiveNumber(line)
                ? Integer.parseInt(line)
                : getPositiveNumber(line);
        dinnerConstructor.setCombosCount(combosCount);

        System.out.println("Введите типы блюда, разделяя символом переноса строки (enter)."
                + "Для завершения ввода введите пустую строку");
        System.out.println("допустимые варианты - " + menuBuilder.getCategories());

        dinnerConstructor.clearCategories();
        while (true) {
            String category = scanner.nextLine();
            if (!menuBuilder.hasCategory(category)) {
                category = getCorrectDishCategory(category);
            }
            if (category.isEmpty()) { // Блок не поставлен сразу после 86, тк из 88 может вернуться пустая строка.
                break;
            }
            dinnerConstructor.addCategory(category);
        }

        dinnerConstructor.generateCombos(menuBuilder.getMenu());
    }

    private static void printDishCombos() {
        System.out.println("Выбранные типы блюд: " + dinnerConstructor.getCategories() + "\n");
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

    public static boolean isPositiveNumber(String value) {
        boolean result = false;
        try {
            if (Integer.parseInt(value) > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Введено неверное значение - " + value);
        }
        return result;
    }

    private static int getPositiveNumber(String value) {
        while (!isPositiveNumber(value)) {
            System.out.println("Введите положительное число");
            value = scanner.nextLine();
        }
        return Integer.parseInt(value);
    }


    /**
     * Для приведения текста (введенных типов и названий блюд) формату:
     * Первая буква прописная, остальные — строчные (суп -> Суп, ЧАЙ -> Чай).
     */
    public static String toNameFormat(String input) { //
        if (input.isEmpty()) {
            return "";
        }
        return Character.toUpperCase(input.charAt(0)) + input.toLowerCase().substring(1);
    }
}