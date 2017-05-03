package pl.com.bottega.lms.application;


import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.commands.CreateUserCommand;
import pl.com.bottega.lms.model.commands.UpdateUserCommand;
import pl.com.bottega.lms.model.User;

public interface UserModule {

    void orderBook(BookNumber bookNumber, Long userId);

    void returnBook(BookNumber bookNumber, Long userId);

}
