package ru.practicum.dinner;

public class StringReader {

    public static String toNameFormat(String input) {
        if (input.isEmpty()) {
            return "";
        }
        return Character.toUpperCase(input.charAt(0)) + input.toLowerCase().substring(1);
    }

    public static boolean isPositiveNumber(String input) {
        boolean result = false;
        try {
            if (Integer.parseInt(input) > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return result;
    }
}