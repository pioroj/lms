package pl.com.bottega.lms.application;


import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.User;

public interface OrderingProcess {

    void orderBook(BookNumber bookNumber, Long userId);

    void returnBook(BookNumber bookNumber, Long userId);

}
