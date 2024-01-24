package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuBuilder {
    private static HashMap<String, ArrayList<String>> menu;

    MenuBuilder() {
        menu = new HashMap<>();
        String[] DISH_CATEGORY = {"Первое", "Второе", "Напиток"};
        for (String category : DISH_CATEGORY) {
            menu.put(category.toLowerCase(), new ArrayList<>());
        }
    }

    static boolean hasCategory(String category) {
        return menu.containsKey(category.toLowerCase());
    }

    static boolean hasDish(String name) {
        for (ArrayList<String> names : menu.values()) {
            for (String item : names) {
                if (name.equalsIgnoreCase(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void addDish(String category, String name) {
        menu.get(category).add(name);
    }
}