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
    public void orderBook(BookNumber bookNumber, Long userId) {
        User user = userRepository.get(userId);
        Book book = bookRepository.get(bookNumber);
        Loan loan = new Loan(user, book);
        book.orderBook();
        orderRepository.put(loan);
    }

    @Override
    @Transactional
    public void returnBook(BookNumber bookNumber, Long userId) {
        User user = userRepository.get(userId);
        Book book = bookRepository.get(bookNumber);
        Loan loan = orderRepository.findOrderBy(user, book);
        book.returnBook();
        orderRepository.put(loan);
    }
}
