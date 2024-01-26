package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    int combosCount;
    private ArrayList<String> categories;
    private ArrayList<ArrayList<String>> combos;

    {
        combosCount = 0;
        categories = new ArrayList<>();
        combos = new ArrayList<>();
    }

    public void setCombosCount(int combosCount) {
        if (combosCount < 1) {
            return;
        }
        this.combosCount = combosCount;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public ArrayList<ArrayList<String>> getCombos() {
        return combos;
    }

    public void addCategory(String name) {
        if (name.isEmpty()) {
            return;
        }
        categories.add(Main.toNameFormat(name));
    }

    public void generateCombos(HashMap<String, ArrayList<String>> menu) {
        combos.clear();
        Random random = new Random();
        for (int i = 0; i < combosCount; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String cat : categories) {
                if (menu.containsKey(cat)) {
                    ArrayList<String> dishes = menu.get(cat);
                    int index = random.nextInt(dishes.size());
                    combo.add(dishes.get(index));
                }
            }

            if (!combo.isEmpty()) {
                combos.add(combo);
            }
        }
    }

    public void clearCategories() {
        categories.clear();
    }
}