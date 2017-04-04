package pl.com.bottega.lms.application.implementation;


import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.lms.application.OrderingProcess;
import pl.com.bottega.lms.model.*;

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
    public void orderBook(Book book, User user) {
        Loan loan = new Loan(user, book);
        book.orderBook();
        orderRepository.put(loan);
    }

    @Override
    @Transactional
    public void returnBook(Book book, User user) {

    }
}
