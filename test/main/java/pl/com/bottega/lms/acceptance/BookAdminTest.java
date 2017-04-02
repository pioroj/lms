package pl.com.bottega.lms.acceptance;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.com.bottega.lms.application.AdminModule;
import pl.com.bottega.lms.application.BookCatalog;
import pl.com.bottega.lms.application.BookDto;
import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.commands.AddBookCommand;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookAdminTest {

    @Autowired
    private BookCatalog bookCatalog;

    @Autowired
    private AdminModule adminModule;

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

}
