package ru.gb.api.Lesson6.hw;

public class Note {
    int id;
    int capacity_RAM;
    int capacity_hard;
    String type_OS;
    String color;

    @Override
    public String toString() {
        String res = String.format("id:%d RAM:%d HARD:%d OS:%s col:%s", id, capacity_RAM, capacity_hard, type_OS, color);
        return res;
    }

    public String toFilter() {
        String filter = String.format("id:%d RAM:%d HARD:%d OS:%s col:%s", id, capacity_RAM, capacity_hard, type_OS, color);
        return filter;
    }
}
