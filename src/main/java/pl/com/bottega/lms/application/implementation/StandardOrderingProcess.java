package pl.com.bottega.lms.application.implementation;


import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.lms.application.OrderingProcess;
import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.BookRepository;
import pl.com.bottega.lms.model.commands.OrderBookCommand;
import pl.com.bottega.lms.model.commands.ReturnBookCommand;

public class StandardOrderingProcess implements OrderingProcess {

    private BookRepository bookRepository;

    public StandardOrderingProcess(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public void orderBook(OrderBookCommand cmd) {
        BookNumber bookNumber = new BookNumber(cmd.getNumber());
        Book book = bookRepository.get(bookNumber);
        book.orderBook(cmd);
    }

    @Override
    public void returnBook(ReturnBookCommand cmd) {
        BookNumber bookNumber = new BookNumber(cmd.getNumber());
        Book book = bookRepository.get(bookNumber);
        book.returnBook(cmd);
    }
}
