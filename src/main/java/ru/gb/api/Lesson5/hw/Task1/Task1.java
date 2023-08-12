package ru.gb.api.Lesson5.hw.Task1;

import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        Map<String, Integer> spisokHashMap = new HashMap<>();
        ArrayList<String> spisok = new ArrayList<>(Arrays.asList(
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"));
        makeSpisok(spisokHashMap, spisok);
        Map<String, Integer> sortedMap = sorting(spisokHashMap);
        for (Map.Entry<String, Integer> elem : sortedMap.entrySet()) {
            if (elem.getValue() != 1) {
                System.out.println("Имя - " + elem.getKey() + ", количество повторений = " + elem.getValue());
            }
        }
    }
    /**
     * @param spisokHashMap - список перенесенный в HashMap
     * @param spisok - исходный список
     * @apiNote Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
     */
    private static void makeSpisok(Map<String, Integer> spisokHashMap, ArrayList<String> spisok) {
        for (int i = 0; i < spisok.size(); i++) {
//            System.out.println("spisok" + i + " = " + spisok.get(i));
            String[] elements = spisok.get(i).split(" ");
//            System.out.println("elements[0] = " + elements[0]);
//            System.out.println("elements[1] = " + elements[1]);
            if (!spisokHashMap.containsKey(elements[0])) {
                spisokHashMap.put((elements[0]), 1);
            } else {
                spisokHashMap.put(elements[0], spisokHashMap.get((elements[0])) + 1);
            }
        }
    }

    private static Map<String, Integer> sorting(Map<String, Integer> spisokHashMap) {
        Map<String, Integer> sortedMap = spisokHashMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));
        return sortedMap;
    }
}
