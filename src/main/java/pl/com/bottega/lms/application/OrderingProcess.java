package pl.com.bottega.lms.application;


import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.User;

public interface OrderingProcess {

    void orderBook(Book book, User user);

    void returnBook(Book book, User user);

}
