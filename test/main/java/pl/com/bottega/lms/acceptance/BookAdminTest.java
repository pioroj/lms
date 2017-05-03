package pl.com.bottega.lms.acceptance;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.com.bottega.lms.application.AdminModule;
import pl.com.bottega.lms.application.BookCatalog;
import pl.com.bottega.lms.application.BookDto;
import pl.com.bottega.lms.application.UserModule;
import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.UserRepository;
import pl.com.bottega.lms.model.commands.AddBookCommand;
import pl.com.bottega.lms.model.commands.CreateUserCommand;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookAdminTest {

    @Autowired
    private AdminModule adminModule;

    @Autowired
	private UserRepository userRepository;

	@Autowired
	private BookCatalog bookCatalog;

    @Test
    public void shouldCreateBook() {
        AddBookCommand cmd = new AddBookCommand();
        cmd.setTitle("Test book");
        cmd.setAuthor("John Doe");
        cmd.setYear(2015);
        BookNumber bookNumber = adminModule.add(cmd);

        BookDto bookDto = bookCatalog.get(bookNumber);
        assertThat(bookDto.getTitle()).isEqualTo("Test book");
        assertThat(bookDto.getNumber()).isEqualTo(bookNumber.getNumber());
    }

    @Test
    public void shouldAddUser() {
        CreateUserCommand createUserCommand = new CreateUserCommand();
        createUserCommand.setName("Jan");
        createUserCommand.setSurname("Nowak");
        createUserCommand.setEmail("jan@jany.pl");
        createUserCommand.setPhoneNumber("123456789");

        Long userId = adminModule.createUser(createUserCommand);

        Assertions.assertThat(userRepository.get(userId).getName()).isEqualTo("Jan");
    }

}
