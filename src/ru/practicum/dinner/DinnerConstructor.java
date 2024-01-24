package ru.practicum.dinner;

import java.util.ArrayList;

public class DinnerConstructor {

    private ArrayList<String> categories;
    private  ArrayList<ArrayList<String>> combos;

    public void addCategory(String name) {
        name = StringReader.toNameFormat(name);
        if (!categories.contains(name)) {
            categories.add(name);
        }
    }

    public void generateCombos(MenuBuilder menu, int count) {

    }

    public ArrayList<ArrayList<String>> getCombos() {
        return combos;
    }
}