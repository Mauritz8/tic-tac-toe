package com.company;

public class Player {
    private int id;
    private String name;
    private char mark;

    public Player(int id, String name, char mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getMark() {
        return mark;
    }
}
