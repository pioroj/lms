package pl.com.bottega.lms.application.implementation;


import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.lms.application.UserModule;
import pl.com.bottega.lms.model.*;
import pl.com.bottega.lms.model.commands.CreateUserCommand;
import pl.com.bottega.lms.model.commands.UpdateUserCommand;

@Transactional
public class StandardUserModule implements UserModule {

    private UserRepository userRepository;
    private BookRepository bookRepository;
    private OrderRepository orderRepository;

    public StandardUserModule(UserRepository userRepository,
							  BookRepository bookRepository,
							  OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void orderBook(BookNumber bookNumber, Long userId) {
        User user = userRepository.get(userId);
        Book book = bookRepository.get(bookNumber);
        Loan loan = new Loan(user, bookNumber);
        book.orderBook();
        orderRepository.put(loan);
    }

    @Override
    public void returnBook(BookNumber bookNumber, Long userId) {
        User user = userRepository.get(userId);
        Book book = bookRepository.get(bookNumber);
        Loan loan = orderRepository.findOrderBy(user, bookNumber);
        book.returnBook();
		loan.endLoaning();
    }
}
