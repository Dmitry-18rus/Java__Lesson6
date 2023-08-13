package ru.gb.api.Lesson6.hw;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Laptop {
    //    Задание на дом :
//              • Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//              • Создать множество ноутбуков.
//              • Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
//              отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
//                  “Введите цифру, соответствующую необходимому критерию:
//                      1 - ОЗУ
//                      2 - Объем ЖД
//                      3 - Операционная система
//                      4 - Цвет …
//              • Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
//              • Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
    private static LinkedHashSet<Note> createData() {
        Note n1 = new Note();
        n1.id = 1;
        n1.capacity_RAM = 512;
        n1.capacity_hard = 500;
        n1.type_OS = "Windows-10";
        n1.color = "black";

        Note n2 = new Note();
        n2.id = 2;
        n2.capacity_RAM = 1024;
        n2.capacity_hard = 320;
        n2.type_OS = "Windows-7";
        n2.color = "red";

        Note n3 = new Note();
        n3.id = 3;
        n3.capacity_RAM = 512;
        n3.capacity_hard = 250;
        n3.type_OS = "Mac-OS";
        n3.color = "black";

        Note n4 = new Note();
        n4.id = 4;
        n4.capacity_RAM = 1024;
        n4.capacity_hard = 500;
        n4.type_OS = "Linux";
        n4.color = "white";

        Note n5 = new Note();
        n5.id = 5;
        n5.capacity_RAM = 512;
        n5.capacity_hard = 320;
        n5.type_OS = "Windows-10";
        n5.color = "grey";

        var notes = new LinkedHashSet<Note>(Arrays.asList(n1, n2, n3, n4, n5));
        return notes;
    }

    private static void print(LinkedHashSet<Note> notes) {
        for (Note elem : notes) {
            System.out.println(elem);
        }
    }

    private static void newNote(LinkedHashSet<Note> notes) {
        Scanner scanner = new Scanner(System.in);
        Note n = new Note();
        n.id = notes.size() + 1;
        System.out.println("Введите емкость оперативной памяти и нажмите Enter:");
        n.capacity_RAM = scanner.nextInt();
        System.out.println("Введите емкость жесткого диска и нажмите Enter:");
        n.capacity_hard = scanner.nextInt();
        System.out.println("Введите тип операционной системы и нажмите Enter:\n"
                + "Например, Windows-10");
        n.type_OS = scanner.next();
        System.out.println("Введите цвет корпуса и нажмите Enter:");
        n.color = scanner.next();
        notes.add(n);
        System.out.println("Внесен новый ноутбук с id = " + n.id);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер команды и нажмите Enter: \n" +
                "1 - просмотр списка ноутбуков;\n" +
                "2 - занести в базу новый ноутбук;\n" +
                "3 - сделать выборку с фильтрацией\n" +
                "100 - для выхода из программы\n");
        int n;
        LinkedHashSet<Note> notes = new LinkedHashSet<Note>(createData());
        while (((n = scanner.nextInt()) < 99 || n > 999)) {
            switch (n) {
                case 1:
                    print(notes);
                    break;
                case 2:
                    newNote(notes);
                    print(notes);
                    break;
                case 3:
                    System.out.println("Введите цифру, соответствующую необходимому критерию фильтра: \n" +
                            "1 - ОЗУ\n" +
                            "2 - Объем ЖД\n" +
                            "3 - Операционная система\n" +
                            "4 - Цвет");
                    int input3 = scanner.nextInt();
                    switch (input3) {
                        case 1:
                            System.out.println("Вы выбрали фильтр по параметру " + "1 - ОЗУ");
                            break;
                        case 2:
                            System.out.println("Вы выбрали фильтр по параметру " + "2 - Объем ЖД");
                            break;
                        case 3:
                            System.out.println("Вы выбрали фильтр по параметру " + "3 - Операционная система");
                            break;
                        case 4:
                            System.out.println("Вы выбрали фильтр по параметру " + "4 - Цвет");
                            break;
                        default:
                            System.out.printf("Неверная команда: " + input3 + ". Попробуйте снова\n");
                    }
            }
        }
    }
}
