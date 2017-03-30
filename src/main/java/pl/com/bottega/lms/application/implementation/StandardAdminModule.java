package pl.com.bottega.lms.application.implementation;


import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.lms.application.AdminModule;
import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.BookRepository;
import pl.com.bottega.lms.model.NumberGenerator;
import pl.com.bottega.lms.model.commands.AddBookCommand;

public class StandardAdminModule implements AdminModule {

    private NumberGenerator numberGenerator;
    private BookRepository bookRepository;

    public StandardAdminModule(NumberGenerator numberGenerator, BookRepository bookRepository) {
        this.numberGenerator = numberGenerator;
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public BookNumber add(AddBookCommand cmd) {
        Book book = new Book(cmd, numberGenerator);
        bookRepository.put(book);
        return book.getNumber();
    }

}
