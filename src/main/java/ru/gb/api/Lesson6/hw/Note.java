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

    public Integer toFilterRAM() {
        return (capacity_RAM);
    }
    public Integer toFilterHard() {
        return (capacity_hard);
    }
    public String toFilterOS() {
        String res1 = String.format("%s", type_OS);
        return res1;
    }
    public String toFilterColor() {
        String res2 = String.format("%s", color);
        return res2;
    }
}

