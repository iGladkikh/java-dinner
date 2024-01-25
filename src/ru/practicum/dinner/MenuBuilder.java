package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MenuBuilder {

    private HashMap<String, ArrayList<String>> menu;

    {
        menu = new HashMap<>();

        ArrayList<String> d1 = new ArrayList<>();
        ArrayList<String> d2 = new ArrayList<>();
        ArrayList<String> d3 = new ArrayList<>();
        d1.addAll(List.of(new String[]{"Каша", "Суп", "Борщ", "Уха"}));
        d2.addAll(List.of(new String[]{"Плов", "Пюре", "Капуста тушеная", "Рагу", "Мясо тушеное"}));
        d3.addAll(List.of(new String[]{"Сок", "Чай", "Кофе", "Морс", "Компот", "Кисель"}));

        menu.put("Первое", d1);
        menu.put("Второе", d2);
        menu.put("Напиток", d3);
    }

    public HashMap<String, ArrayList<String>> getMenu() {
        return menu;
    }

    public boolean hasCategory(String category) {
        category = StringReader.toNameFormat(category);
        return menu.containsKey(category);
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

    boolean addDish(String category, String name) {
        if (category.isEmpty() || name.isEmpty()) {
            return false;
        }

        boolean result = false;
        category = StringReader.toNameFormat(category);
        name = StringReader.toNameFormat(name);
        if (!menu.containsKey(category)) {
            menu.put(category, new ArrayList<>());
        }
        result = menu.get(category).add(name);

        return result;
    }
}