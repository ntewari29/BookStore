package unit.com.nishant.tdd;

import com.nishant.tdd.Book;
import com.nishant.tdd.BookStore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class BookStoreTest {

    @Test
    public void findsNoBooksWhenNoBookMatchesTheGivenTitle() {
        Book lord_of_the_rings = new Book("Lord of the Rings");


        BookStore bookStore = new BookStore();
        bookStore.addBook(lord_of_the_rings);

        List<Book> actual = bookStore.findByTitle("The Hobbit");

        assertThat(actual, is(empty()));
    }

    @Test
    public void findsAllBooksThatMatchTheGivenTitle() {
        Book lord_of_the_rings = new Book("Lord of the Rings");

        BookStore bookStore = new BookStore();
        bookStore.addBook(lord_of_the_rings);

        List<Book> actual = bookStore.findByTitle("Lord of the Rings");
        assertThat(actual, is(asList(lord_of_the_rings)));
    }

    @Test
    public void findsAllBooksWithTitlesThatContainTheSearchText() {
        Book lord_of_the_rings = new Book("Lord of the Rings");
        Book the_hobbit = new Book("The Hobbit");
        Book a_new_hope = new Book("A New Hope");

        BookStore bookStore = new BookStore();
        bookStore.addBook(lord_of_the_rings);
        bookStore.addBook(the_hobbit);
        bookStore.addBook(a_new_hope);

        List<Book> actual = bookStore.findByTitle("the");
        assertThat(
                actual,
                is(asList(lord_of_the_rings, the_hobbit)));
    }
}
