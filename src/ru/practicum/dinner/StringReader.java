package ru.practicum.dinner;

public class StringReader {

    public static String toNameFormat(String input) {
        return Character.toUpperCase(input.charAt(0)) + input.toLowerCase().substring(1);
    }

    public static int getPositiveInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            return 0;
        }
    }
}