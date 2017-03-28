package pl.com.bottega.lms.infrastructure;


import pl.com.bottega.lms.application.BookCatalog;
import pl.com.bottega.lms.application.BookDto;
import pl.com.bottega.lms.application.BookQuery;
import pl.com.bottega.lms.application.BookSearchResults;
import pl.com.bottega.lms.model.BookNumber;

public class JPABookCatalog implements BookCatalog {

    @Override
    public BookSearchResults find(BookQuery bookQuery) {
        return null;
    }

    @Override
    public BookDto get(BookNumber bookNumber) {
        return null;
    }

}
