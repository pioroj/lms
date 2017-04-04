package pl.com.bottega.lms.application.implementation;


import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.lms.application.AdminModule;
import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.BookRepository;
import pl.com.bottega.lms.model.commands.AddBookCommand;

@Transactional
public class StandardAdminModule implements AdminModule {

    private BookRepository bookRepository;

    public StandardAdminModule(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookNumber add(AddBookCommand cmd) {
        Book book = new Book(cmd);
        bookRepository.put(book);
        return book.getNumber();
    }

}
