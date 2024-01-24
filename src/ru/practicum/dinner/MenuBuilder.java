package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuBuilder {

    private HashMap<String, ArrayList<String>> menu;

    MenuBuilder() {
        menu = new HashMap<>();
        String[] DISH_CATEGORY = {"первое", "второе", "напиток"};
        for (String category : DISH_CATEGORY) {
            category = StringReader.toNameFormat(category);
            menu.put(category, new ArrayList<>());
        }
        System.out.println(menu);
    }

    public HashMap<String, ArrayList<String>> getMenu() {
        return menu;
    }

    boolean hasCategory(String category) {
        category = StringReader.toNameFormat(category);
        return menu.containsKey(category);
    }

    boolean hasDish(String name) {
        for (ArrayList<String> names : menu.values()) {
            for (String item : names) {
                if (name.equalsIgnoreCase(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    void addDish(String category, String name) {
        category = StringReader.toNameFormat(category);
        name = StringReader.toNameFormat(name);
        menu.get(category).add(name);
    }
}