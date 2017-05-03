package pl.com.bottega.lms.application.implementation;


import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.lms.application.AdminModule;
import pl.com.bottega.lms.model.*;
import pl.com.bottega.lms.model.commands.AddBookCommand;
import pl.com.bottega.lms.model.commands.CreateUserCommand;
import pl.com.bottega.lms.model.commands.UpdateUserCommand;

@Transactional
public class StandardAdminModule implements AdminModule {

    private BookRepository bookRepository;
    private UserRepository userRepository;

	public StandardAdminModule(BookRepository bookRepository,
							   UserRepository userRepository) {
		this.bookRepository = bookRepository;
		this.userRepository = userRepository;
	}

	@Override
    public BookNumber add(AddBookCommand cmd) {
        Book book = new Book(cmd);
        bookRepository.put(book);
        return book.getNumber();
    }

	@Override
	public Long createUser(CreateUserCommand cmd) {
		User user = new User(cmd);
		userRepository.put(user);
		return user.getId();
	}

	@Override
	public void updateUser(UpdateUserCommand cmd) {

	}

	@Override
	public void deleteUser(Long userId) {

	}

	@Override
	public User get(Long userId) {
		return userRepository.get(userId);
	}

}
