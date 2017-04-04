package pl.com.bottega.lms;


import org.junit.Test;
import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.commands.AddBookCommand;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldBeAvailableAfterCreate() {
        Book book = given().newBook();
        System.out.println(book.getNumber());

        assertEquals(true, book.isAvailable());
    }

    @Test
    public void shouldBeUnavailableAfterOrdering() {
        Book book = given().newBook();

        book.orderBook();

        System.out.println(book.getNumber());

        assertEquals(false, book.isAvailable());
    }

    @Test
    public void shouldBeAvailableAfterReturning() {
        Book book = given().newBook();

        book.orderBook();

        book.returnBook();

        assertEquals(true, book.isAvailable());
    }

    private BookAssembler given() {
        return new BookAssembler();
    }

    class BookAssembler {

        Book newBook() {
            AddBookCommand cmd = new AddBookCommand();
            cmd.setTitle("Java - podstawy");
            cmd.setAuthor("John Doe");
            cmd.setYear(1997);
            return new Book(cmd);
        }

    }

}
