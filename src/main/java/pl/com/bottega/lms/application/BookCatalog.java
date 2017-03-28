package pl.com.bottega.lms.application;


import pl.com.bottega.lms.model.BookNumber;

public interface BookCatalog {

    BookSearchResults find(BookQuery bookQuery);

    BookDto get(BookNumber bookNumber);

}
