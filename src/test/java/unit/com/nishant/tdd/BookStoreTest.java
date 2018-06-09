package unit.com.nishant.tdd;

import com.nishant.tdd.Book;
import com.nishant.tdd.BookStore;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class BookStoreTest {

    @Test
    public void findsNoBooksWhenNoBookMatchesTheGivenTitle() {
        Book lord_of_the_rings = new Book("Lord of the Rings", 2000, "J.R.R Tolkien");


        BookStore bookStore = new BookStore();
        bookStore.addBook(lord_of_the_rings);

        List<Book> actual = bookStore.findByTitle("The Hobbit");
        assertThat(actual, is(empty()));
    }

    @Test
    public void findsAllBooksThatMatchTheGivenTitle() {
        Book lord_of_the_rings = new Book("Lord of the Rings", 2000, "J.R.R Tolkien");


        BookStore bookStore = new BookStore();
        bookStore.addBook(lord_of_the_rings);

        List<Book> actual = bookStore.findByTitle("Lord of the Rings");
        assertThat(actual, is(asList(lord_of_the_rings)));
    }

    @Test
    public void findsAllBooksWithTitlesThatContainTheSearchText() {
        Book lord_of_the_rings = new Book("Lord of the Rings", 2000, "J.R.R Tolkien");
        Book the_hobbit = new Book("The Hobbit", 2000, "J.R.R Tolkien");
        Book a_new_hope = new Book("A New Hope", 2000, "George Lucas");

        BookStore bookStore = new BookStore();
        bookStore.addBook(lord_of_the_rings);
        bookStore.addBook(the_hobbit);
        bookStore.addBook(a_new_hope);

        List<Book> actual = bookStore.findByTitle("the");
        assertThat(
                actual,
                is(asList(lord_of_the_rings, the_hobbit)));
    }

    @Test
    public void findsNoBooksWhenNoBookWasPublishedInTheGivenYear() {
        Book lord_of_the_rings = new Book("Lord of the Rings", 2000, "J.R.R Tolkien");
        Book the_hobbit = new Book("The Hobbit", 2000, "J.R.R Tolkien");
        Book a_new_hope = new Book("A New Hope", 2000, "George Lucas");

        BookStore bookStore = new BookStore();
        bookStore.addBook(lord_of_the_rings);
        bookStore.addBook(the_hobbit);
        bookStore.addBook(a_new_hope);

        List<Book> actual = bookStore.findByPublicationYear(2001);
        assertThat(
                actual,
                is(empty()));
    }

    @Test
    public void findsAllBooksPublishedInTheGivenYear() {
        Book lord_of_the_rings = new Book("Lord of the Rings", 2000, "J.R.R Tolkien");
        Book the_hobbit = new Book("The Hobbit", 2001, "J.R.R Tolkien");
        Book a_new_hope = new Book("A New Hope", 2000, "George Lucas");
        Book the_empire_strikes_back = new Book("The Empire Strikes Back", 2001, "George Lucas");

        BookStore bookStore = new BookStore();
        bookStore.addBook(lord_of_the_rings);
        bookStore.addBook(the_hobbit);
        bookStore.addBook(a_new_hope);
        bookStore.addBook(the_empire_strikes_back);

        List<Book> actual = bookStore.findByPublicationYear(2001);
        assertThat(
                actual,
                is(asList(the_hobbit, the_empire_strikes_back)));
    }

    @Test
    public void findsAllBooksPublishedInTheGivenYearWithMatchingTitle() {
        Book lord_of_the_rings = new Book("Lord of the Rings", 2000, "J.R.R Tolkien");
        Book the_hobbit = new Book("The Hobbit", 2001, "J.R.R Tolkien");
        Book a_new_hope = new Book("A New Hope", 2000, "George Lucas");
        Book the_empire_strikes_back = new Book("The Empire Strikes Back", 2001, "George Lucas");

        BookStore bookStore = new BookStore();
        bookStore.addBook(lord_of_the_rings);
        bookStore.addBook(the_hobbit);
        bookStore.addBook(a_new_hope);
        bookStore.addBook(the_empire_strikes_back);

        List<Book> actual = bookStore.findByPublicationYearAndTitle(2000, "new");
        assertThat(
                actual,
                is(asList(a_new_hope)));
    }

    @Test
    public void findsAllBooksPublishedInTheGivenYearOrWithAMatchingTitle() {
        Book lord_of_the_rings = new Book("Lord of the Rings", 2000, "J.R.R Tolkien");
        Book the_hobbit = new Book("The Hobbit", 2001, "J.R.R Tolkien");
        Book a_new_hope = new Book("A New Hope", 2000, "George Lucas");
        Book the_empire_strikes_back = new Book("The Empire Strikes Back", 2001, "George Lucas");

        BookStore bookStore = new BookStore();
        bookStore.addBook(lord_of_the_rings);
        bookStore.addBook(the_hobbit);
        bookStore.addBook(a_new_hope);
        bookStore.addBook(the_empire_strikes_back);

        List<Book> actual = bookStore.findByPublicationYearOrTitle(2001, "new");
        assertThat(
                actual,
                is(asList(the_hobbit, a_new_hope, the_empire_strikes_back)));
    }


    @Test
    public void findsAllBooksPublishedBetweenTheGivenYearsAndWithATitleThatDoesNotMatch() {
        Book lord_of_the_rings = new Book("Lord of the Rings", 2000, "J.R.R Tolkien");
        Book the_hobbit = new Book("The Hobbit", 2001, "J.R.R Tolkien");
        Book a_new_hope = new Book("A New Hope", 2000, "George Lucas");
        Book the_empire_strikes_back = new Book("The Empire Strikes Back", 2001, "George Lucas");
        Book return_of_the_jedi = new Book("Return of the Jedi", 2003, "George Lucas");
        Book the_last_jedi = new Book("The Last Jedi", 2004, "George Lucas");
        Book the_force_awakens = new Book("The Force Awakens", 2004, "George Lucas");

        BookStore bookStore = new BookStore();
        bookStore.addBook(lord_of_the_rings);
        bookStore.addBook(the_hobbit);
        bookStore.addBook(a_new_hope);
        bookStore.addBook(the_empire_strikes_back);
        bookStore.addBook(return_of_the_jedi);
        bookStore.addBook(the_last_jedi);
        bookStore.addBook(the_force_awakens);

        List<Book> actual = bookStore.findAllBooksPublishedWithinNotWithTitle(2001, 2003, "jedi");
        assertThat(
                actual,
                is(asList(the_hobbit, the_empire_strikes_back)));
    }

    @Test
    public void findsAllBooksPublishedByAGivenAuthor() {
        Book lord_of_the_rings = new Book("Lord of the Rings", 2000, "J.R.R Tolkien");
        Book the_hobbit = new Book("The Hobbit", 2001, "J.R.R Tolkien");
        Book a_new_hope = new Book("A New Hope", 2000, "George Lucas");
        Book the_empire_strikes_back = new Book("The Empire Strikes Back", 2001, "George Lucas");
        Book return_of_the_jedi = new Book("Return of the Jedi", 2003, "George Lucas");
        Book the_last_jedi = new Book("The Last Jedi", 2004, "George Lucas");
        Book the_force_awakens = new Book("The Force Awakens", 2004, "George R Lucas");

        BookStore bookStore = new BookStore();
        bookStore.addBook(lord_of_the_rings);
        bookStore.addBook(the_hobbit);
        bookStore.addBook(a_new_hope);
        bookStore.addBook(the_empire_strikes_back);
        bookStore.addBook(return_of_the_jedi);
        bookStore.addBook(the_last_jedi);
        bookStore.addBook(the_force_awakens);

        List<Book> actual = bookStore.finaAllBooksByAuthor("George Lucas");
        assertThat(
                actual,
                is(asList(a_new_hope, the_empire_strikes_back, return_of_the_jedi, the_last_jedi)));
    }

    @Test
    public void findsAllBooksPublishedByAGivenAuthorAndWithinPublicationYear() {
        Book lord_of_the_rings = new Book("Lord of the Rings", 2000, "J.R.R Tolkien");
        Book the_hobbit = new Book("The Hobbit", 2001, "J.R.R Tolkien");
        Book a_new_hope = new Book("A New Hope", 2000, "George Lucas");
        Book the_empire_strikes_back = new Book("The Empire Strikes Back", 2001, "George Lucas");
        Book return_of_the_jedi = new Book("Return of the Jedi", 2003, "George Lucas");
        Book the_last_jedi = new Book("The Last Jedi", 2004, "George Lucas");
        Book the_force_awakens = new Book("The Force Awakens", 2004, "George R Lucas");

        BookStore bookStore = new BookStore();
        bookStore.addBook(lord_of_the_rings);
        bookStore.addBook(the_hobbit);
        bookStore.addBook(a_new_hope);
        bookStore.addBook(the_empire_strikes_back);
        bookStore.addBook(return_of_the_jedi);
        bookStore.addBook(the_last_jedi);
        bookStore.addBook(the_force_awakens);

        List<Book> actual = bookStore.finaAllBooksByAuthorAndWithinPublicationYear(2000, 2003, "George Lucas");
        assertThat(
                actual,
                is(asList(the_empire_strikes_back)));
    }

}
