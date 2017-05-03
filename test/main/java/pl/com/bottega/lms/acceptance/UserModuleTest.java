package pl.com.bottega.lms.acceptance;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.com.bottega.lms.application.AdminModule;
import pl.com.bottega.lms.application.OrderingProcess;
import pl.com.bottega.lms.application.UserModule;
import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.BookRepository;
import pl.com.bottega.lms.model.UserRepository;
import pl.com.bottega.lms.model.commands.AddBookCommand;
import pl.com.bottega.lms.model.commands.CreateUserCommand;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserModuleTest {

	@Autowired
	private UserModule userModule;

	@Autowired
	private AdminModule adminModule;

    @Autowired
	private BookRepository bookRepository;

    @Test
    public void shouldOrderBook() {
        BookNumber bookNumber = createBook();
        CreateUserCommand createUserCommand = createUser();
        Long userId = adminModule.createUser(createUserCommand);

		userModule.orderBook(bookNumber, userId);
		Book book = bookRepository.get(bookNumber);

        assertThat(book.isAvailable()).isFalse();
    }

    @Test
    public void shouldReturnBook() {
        BookNumber bookNumber = createBook();
        CreateUserCommand createUserCommand = createUser();
        Long userId = adminModule.createUser(createUserCommand);

		userModule.orderBook(bookNumber, userId);
		userModule.returnBook(bookNumber, userId);
		Book book = bookRepository.get(bookNumber);

		assertThat(book.isAvailable()).isTrue();
    }

    private CreateUserCommand createUser() {
        CreateUserCommand createUserCommand = new CreateUserCommand();
        createUserCommand.setName("Jan");
        createUserCommand.setSurname("Nowak");
        createUserCommand.setEmail("jan@jany.pl");
        createUserCommand.setPhoneNumber("123456789");
        return createUserCommand;
    }

    private BookNumber createBook() {
        AddBookCommand addBookCommand = new AddBookCommand();
        addBookCommand.setTitle("Java 3");
        addBookCommand.setAuthor("John Doe");
        addBookCommand.setYear(1997);
        return adminModule.add(addBookCommand);
    }

}
