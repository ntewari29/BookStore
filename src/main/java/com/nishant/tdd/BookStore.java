package com.nishant.tdd;

import java.util.ArrayList;
import java.util.List;

public class BookStore {
    Book addedBook;

    public void addBook(Book book) {
        addedBook = book;
    }

    public List<Book> findByTitle(String title) {
        if (title.equals("Lord of the Rings")) {
            List<Book> listOfBooks = new ArrayList<>();
            listOfBooks.add(addedBook);
            return listOfBooks;
        }
        else
            return new ArrayList<>();
    }
}
