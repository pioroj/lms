package pl.com.bottega.lms.infrastructure;

import org.springframework.context.annotation.Bean;
import pl.com.bottega.lms.application.BookCatalog;
import pl.com.bottega.lms.model.BookRepository;

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

}
