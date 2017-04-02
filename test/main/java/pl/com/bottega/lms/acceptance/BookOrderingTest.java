package pl.com.bottega.lms.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.com.bottega.lms.application.AdminModule;
import pl.com.bottega.lms.application.BookCatalog;
import pl.com.bottega.lms.application.BookDto;
import pl.com.bottega.lms.application.OrderingProcess;
import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.BookRepository;
import pl.com.bottega.lms.model.User;
import pl.com.bottega.lms.model.commands.AddBookCommand;
import pl.com.bottega.lms.model.commands.OrderBookCommand;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookOrderingTest {

    @Autowired
    private AdminModule adminModule;

    @Autowired
    private OrderingProcess orderingProcess;

    @Autowired
    private BookCatalog bookCatalog;

    @Test
    public void shouldOrderBook() {
        //given
        AddBookCommand addBookCommand = new AddBookCommand();
        addBookCommand.setTitle("Java 8");
        addBookCommand.setAuthor("Mark Smith");
        BookNumber bookNumber = adminModule.add(addBookCommand);

        //when
        OrderBookCommand orderBookCommand = new OrderBookCommand();
        orderBookCommand.setNumber(bookNumber.getNumber());
        orderBookCommand.setUser(new User(1L));
        orderingProcess.orderBook(orderBookCommand);

        //then
        BookDto bookDto = bookCatalog.get(bookNumber);
        assertThat(bookDto.isAvailable()).isFalse();

    }

}
