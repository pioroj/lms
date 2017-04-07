package pl.com.bottega.lms.infrastructure;


import pl.com.bottega.lms.application.*;
import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.Loan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPABookCatalog implements BookCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BookSearchResults find(BookQuery bookQuery) {
        return null;
    }

    @Override
    public BookDto get(BookNumber bookNumber) {
        Book book = entityManager.find(Book.class, bookNumber);

        BookDto bookDto = new BookDto();
        bookDto.setNumber(bookNumber.getNumber());
        bookDto.setTitle(book.getTitle());
        bookDto.setAvailable(book.isAvailable());

        return bookDto;
    }

}
