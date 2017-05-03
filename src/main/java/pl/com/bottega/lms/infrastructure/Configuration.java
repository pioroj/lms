package pl.com.bottega.lms.infrastructure;

import org.springframework.context.annotation.Bean;
import pl.com.bottega.lms.application.AdminModule;
import pl.com.bottega.lms.application.BookCatalog;
import pl.com.bottega.lms.application.UserModule;
import pl.com.bottega.lms.application.implementation.StandardAdminModule;
import pl.com.bottega.lms.application.implementation.StandardUserModule;
import pl.com.bottega.lms.model.BookRepository;
import pl.com.bottega.lms.model.OrderRepository;
import pl.com.bottega.lms.model.UserRepository;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public BookCatalog bookCatalog() {
        return new JPABookCatalog();
    }

    @Bean
    public BookRepository bookRepository() {
        return new JPABookRepository();
    }

    @Bean
    public AdminModule adminModule(BookRepository bookRepository,
								   UserRepository userRepository
                                   ) {
        return new StandardAdminModule(bookRepository, userRepository);
    }

    @Bean
    public OrderRepository orderRepository() {
        return new JPAOrderRepository();
    }

    @Bean
    public UserRepository userRepository() {
        return new JPAUserRepository();
    }

    @Bean
    public UserModule userModule(UserRepository userRepository,
								 BookRepository bookRepository,
								 OrderRepository orderRepository) {
        return new StandardUserModule(userRepository, bookRepository, orderRepository);
    }

}
