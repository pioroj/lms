package pl.com.bottega.lms;


import org.junit.Test;
import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.NumberGenerator;
import pl.com.bottega.lms.model.commands.AddBookCommand;
import pl.com.bottega.lms.model.commands.OrderBookCommand;
import pl.com.bottega.lms.model.commands.ReturnBookCommand;

import java.time.LocalDate;

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

        OrderBookCommand cmd = new OrderBookCommand();
        book.orderBook(cmd);

        System.out.println(book.getNumber());

        assertEquals(false, book.isAvailable());
    }

    @Test
    public void shouldBeAvailableAfterReturning() {
        Book book = given().newBook();

        OrderBookCommand orderCmd = new OrderBookCommand();
        book.orderBook(orderCmd);

        ReturnBookCommand returnCmd = new ReturnBookCommand();
        book.returnBook(returnCmd);

        assertEquals(true, book.isAvailable());
    }

    private BookAssembler given() {
        return new BookAssembler();
    }

    class BookAssembler {

        Book newBook() {
            AddBookCommand cmd = new AddBookCommand();
            NumberGenerator generator = new NumberGenerator();
            cmd.setTitle("Java - podstawy");
            cmd.setAuthor("John Doe");
            cmd.setNumber(generator.generate().toString());
            cmd.setYear(1997);
            return new Book(cmd, generator);
        }

    }

}
