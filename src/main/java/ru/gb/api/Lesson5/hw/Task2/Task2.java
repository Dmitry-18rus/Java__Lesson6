package ru.gb.api.Lesson5.hw.Task2;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
//        Подсчитать количество вхождения каждого слова
//        Пример:
//        Россия идет вперед всей планеты. Планета - это не Россия.
//
        String str = new String();
        Map<String, Integer> spisokHashMap = new HashMap<>();
        str = "Россия идет вперед всей планеты. Планета — это не Россия.";
        extracted(str, spisokHashMap);
        extractedPrint(spisokHashMap);
    }
    private static void extractedPrint(Map<String, Integer> spisokHashMap) {
        for (Map.Entry<String, Integer> elem : spisokHashMap.entrySet()) {
            System.out.println("Слово " + "<" + elem.getKey() + ">"+ " повторяется " + elem.getValue() + " раз");
        }
    }
    private static void extracted(String str, Map<String, Integer> spisokHashMap) {
        String [] slova = str.toLowerCase().replace('.', ' ').replace('—', ' ').split(" ");
        for (String slovum : slova) {
            if (slovum.length() > 1) {
//                System.out.println(slovum);
                if (!spisokHashMap.containsKey(slovum)) {
                    spisokHashMap.put((slovum), 1);
                } else {
                    spisokHashMap.put(slovum, spisokHashMap.get((slovum)) + 1);
                }
            }
        }
    }
}
