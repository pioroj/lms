package pl.com.bottega.lms.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.lms.application.*;
import pl.com.bottega.lms.model.*;
import pl.com.bottega.lms.model.commands.AddBookCommand;
import pl.com.bottega.lms.model.commands.CreateUserCommand;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class BookOrderingTest {

    @Autowired
    private AdminModule adminModule;

    @Autowired
    private OrderingProcess orderingProcess;

    @Autowired
    private BookCatalog bookCatalog;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserManagement userManagement;

    @Test
    public void shouldOrderBook() {
        BookNumber bookNumber = createBook();
        CreateUserCommand createUserCommand = createUser();
        Long userId = userManagement.createUser(createUserCommand);
        Book book = bookRepository.get(bookNumber);

        orderingProcess.orderBook(bookNumber, userId);

        assertThat(book.isAvailable()).isFalse();
    }

    @Test
    public void shouldReturnBook() {
        BookNumber bookNumber = createBook();
        CreateUserCommand createUserCommand = createUser();
        Long userId = userManagement.createUser(createUserCommand);
        Book book = bookRepository.get(bookNumber);

        orderingProcess.orderBook(bookNumber, userId);
        orderingProcess.returnBook(bookNumber, userId);

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
        addBookCommand.setTitle("Java");
        addBookCommand.setAuthor("John Doe");
        addBookCommand.setYear(1997);
        return adminModule.add(addBookCommand);
    }

}
