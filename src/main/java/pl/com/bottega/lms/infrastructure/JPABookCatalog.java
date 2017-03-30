package pl.com.bottega.lms.infrastructure;


import pl.com.bottega.lms.application.BookCatalog;
import pl.com.bottega.lms.application.BookDto;
import pl.com.bottega.lms.application.BookQuery;
import pl.com.bottega.lms.application.BookSearchResults;
import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.BookNumber;

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
        return bookDto;
    }

}
