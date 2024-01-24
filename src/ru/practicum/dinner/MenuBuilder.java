package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuBuilder {
    private static final HashMap<String, ArrayList<Dish>> menu = new HashMap<>();

    MenuBuilder() {
        String[] DISH_CATEGORY = {"Первое", "Второе", "Напиток"};
        for (String category : DISH_CATEGORY) {
            menu.put(category, new ArrayList<>());
        }
    }

    static boolean hasCategory(String category) {
        return menu.containsKey(category);
    }

    static boolean hasDish(String name) {
        for (ArrayList<Dish> dishList : menu.values()) {
            for (Dish item : dishList) {
                if (name.equalsIgnoreCase(item.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean hasDish(Dish dish) {
        String name = dish.getName();
        return hasDish(name);
    }

    static void addDish(String category, Dish dish) {
        menu.get(category).add(dish);
    }
}
