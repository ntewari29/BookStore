package com.nishant.tdd;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

    public interface Matcher {
        boolean matches(Book b);
    }

    List<Book> listOfBooks = new ArrayList<>();

    public void addBook(Book book) {
        listOfBooks.add(book);
    }

    public List<Book> findByTitle(String title) {
        return findMatchingBooks(byTitle(title));
    }

    public List<Book> findByPublicationYear(int year) {
        return findMatchingBooks(byYear(year));
    }

    public List<Book> findByPublicationYearAndTitle(int year, String title) {
        return findMatchingBooks(and(byYear(year), byTitle(title)));
    }

    public List<Book> findByPublicationYearOrTitle(int year, String title) {
        return findMatchingBooks(or(byYear(year), byTitle(title)));
    }

    public List<Book> findAllBooksPublishedWithinNotWithTitle(int year1, int year2, String title) {
        return findMatchingBooks(and(btwnYear(year1, year2), notInTitle(title)));
    }

    public List<Book> finaAllBooksByAuthor(String author) {
        return findMatchingBooks(byAuthor(author));
    }

    public List<Book> finaAllBooksByAuthorAndWithinPublicationYear(int year1, int year2, String author) {
        return findMatchingBooks(and(withinYear(year1, year2), byAuthor(author)));
    }

    private List<Book> findMatchingBooks(Matcher m) {
        List<Book> results = new ArrayList<>();
        for (Book book : listOfBooks) {
            if (m.matches(book)) {
                results.add(book);
            }
        }
        return results;
    }

    private Matcher and(Matcher... matchers) {
        return new Matcher() {
            public boolean matches(Book b) {
                for (Matcher m : matchers) {
                    if (!m.matches(b))
                        return false;
                }
                return true;
            }
        };
    }

    private Matcher or(Matcher... matchers) {
        return new Matcher() {
            public boolean matches(Book b) {
                for (Matcher m : matchers) {
                    if (m.matches(b))
                        return true;
                }
                return false;
            }
        };
    }

    private Matcher byTitle(String title) {
        return new Matcher() {
            public boolean matches(Book b) {
                return b.title.toLowerCase().contains(title.toLowerCase());
            }
        };
    }

    private Matcher byYear(int year) {
        return new Matcher() {
            public boolean matches(Book b) {
                return b.publicationYear == year;
            }
        };
    }

    private Matcher btwnYear(int year1, int year2) {
        return new Matcher() {
            public boolean matches(Book b) {
                boolean startyear = b.publicationYear >= year1;
                boolean endyear = b.publicationYear <= year2;
                return startyear && endyear;
            }
        };
    }

    private Matcher withinYear(int year1, int year2) {
        return new Matcher() {
            public boolean matches(Book b) {
                boolean startyear = b.publicationYear > year1;
                boolean endyear = b.publicationYear < year2;
                return startyear && endyear;
            }
        };
    }

    private Matcher notInTitle(String title) {
        return new Matcher() {
            public boolean matches(Book b) {
                return !b.title.toLowerCase().contains(title.toLowerCase());
            }
        };
    }

    private Matcher byAuthor(String author) {
        return new Matcher() {
            public boolean matches(Book b) {
                return b.author.toLowerCase().contains(author.toLowerCase());
            }
        };

    }


}
