package com.jackie.wowjava.best.practice.java.orika.model;

public enum BookType {
    NOVEL(1),
    ESSAY(2);

    private int value;

    BookType(int value) {
        this.value = value;
    }

    public static BookType getBookType(int value) {
        BookType bookType = null;

        switch (value) {
            case 1:
                bookType = NOVEL;
                break;
            case 2:
                bookType = ESSAY;
                break;
            default:
                break;
        }
        return bookType;
    }

    public int getValue() {
        return value;
    }
}
