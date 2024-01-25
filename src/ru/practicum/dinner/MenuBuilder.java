package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MenuBuilder {

    private HashMap<String, ArrayList<String>> menu;

    {
        menu = new HashMap<>();
    }

    public HashMap<String, ArrayList<String>> getMenu() {
        return menu;
    }

    public Set<String> getCategories() {
        return menu.keySet();
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

    public boolean hasCategory(String category) {
        category = StringReader.toNameFormat(category);
        return menu.containsKey(category);
    }

    boolean addDish(String category, String name) {
        if (category.isEmpty() || name.isEmpty()) {
            return false;
        }

        category = StringReader.toNameFormat(category);
        name = StringReader.toNameFormat(name);
        if (!menu.containsKey(category)) {
            menu.put(category, new ArrayList<>());
        }

        return menu.get(category).add(name);
    }
}