package pl.com.bottega.lms.application;


import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.commands.AddBookCommand;

public interface AdminModule {

    BookNumber add(AddBookCommand cmd);

}
