package pl.com.bottega.lms.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.lms.application.AdminModule;
import pl.com.bottega.lms.application.BookCatalog;
import pl.com.bottega.lms.application.OrderingProcess;
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

    @Test
    public void shouldOrderBook() {
        AddBookCommand addBookCommand = new AddBookCommand();
        addBookCommand.setTitle("Java");
        addBookCommand.setAuthor("John Doe");
        addBookCommand.setYear(1997);
        Book book = new Book(addBookCommand);
        bookRepository.put(book);

        CreateUserCommand createUserCommand = new CreateUserCommand();
        createUserCommand.setName("Jan");
        createUserCommand.setSurname("Nowak");
        createUserCommand.setEmail("jan@jany.pl");
        createUserCommand.setPhoneNumber("123456789");
        User user = new User(createUserCommand);
        userRepository.put(user);

        orderingProcess.orderBook(book, user);

        assertThat(bookRepository.get(book.getNumber()).isAvailable()).isFalse();
    }

}
