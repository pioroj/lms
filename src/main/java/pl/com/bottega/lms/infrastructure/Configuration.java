package pl.com.bottega.lms.infrastructure;

import org.springframework.context.annotation.Bean;
import pl.com.bottega.lms.application.AdminModule;
import pl.com.bottega.lms.application.BookCatalog;
import pl.com.bottega.lms.application.implementation.StandardAdminModule;
import pl.com.bottega.lms.model.BookRepository;
import pl.com.bottega.lms.model.NumberGenerator;

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
    public NumberGenerator numberGenerator() {
        return new NumberGenerator();
    }

    @Bean
    public AdminModule adminModule(NumberGenerator numberGenerator, BookRepository bookRepository) {
        return new StandardAdminModule(numberGenerator, bookRepository);
    }

}
