package com.nishant.tdd;

public class Book {
    public final String title;
    public final int publicationYear;
    public final String author;

    public Book(String title, int publicationYear, String author) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public String toString() {
        return title;
    }
}
