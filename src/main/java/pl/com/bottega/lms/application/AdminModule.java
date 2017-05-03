package pl.com.bottega.lms.application;


import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.User;
import pl.com.bottega.lms.model.commands.AddBookCommand;
import pl.com.bottega.lms.model.commands.CreateUserCommand;
import pl.com.bottega.lms.model.commands.UpdateUserCommand;

public interface AdminModule {

    BookNumber add(AddBookCommand cmd);

	Long createUser(CreateUserCommand cmd);

	void updateUser(UpdateUserCommand cmd);

	void deleteUser(Long userId);

	User get(Long userId);

}
