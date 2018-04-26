package unit.com.nishant.tdd;

import com.nishant.tdd.Book;
import com.nishant.tdd.BookStore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class BookStoreTest {

    @Test
    public void findsNoBooksWhenNoBookMatchesTheGivenTitle() {
        BookStore bookStore = new BookStore();
        bookStore.addBook(new Book("Lord of the Rings"));

        assertThat(bookStore.findByTitle("The Hobbit"), is(empty()));
    }
}
