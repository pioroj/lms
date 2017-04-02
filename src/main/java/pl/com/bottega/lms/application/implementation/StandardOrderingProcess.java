package pl.com.bottega.lms.application.implementation;


import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.lms.application.OrderingProcess;
import pl.com.bottega.lms.model.*;
import pl.com.bottega.lms.model.commands.OrderBookCommand;
import pl.com.bottega.lms.model.commands.ReturnBookCommand;

public class StandardOrderingProcess implements OrderingProcess {

    private BookRepository bookRepository;
    private OrderRepository orderRepository;
    private UserRepository userRepository;

    public StandardOrderingProcess(BookRepository bookRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void orderBook(OrderBookCommand cmd) {
        BookNumber bookNumber = new BookNumber(cmd.getNumber());
        Book book = bookRepository.get(bookNumber);
        book.orderBook(cmd);
        Order order = new Order(new User(cmd.getUser().getId()), book);
        orderRepository.put(order);

    }

    @Override
    @Transactional
    public void returnBook(ReturnBookCommand cmd) {
        BookNumber bookNumber = new BookNumber(cmd.getNumber());
        Book book = bookRepository.get(bookNumber);
        book.returnBook(cmd);
    }
}
