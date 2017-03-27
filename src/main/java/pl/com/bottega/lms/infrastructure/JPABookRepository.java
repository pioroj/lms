package pl.com.bottega.lms.infrastructure;


import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.BookRepository;

public class JPABookRepository implements BookRepository {


    @Override
    public void put(Book book) {

    }

    @Override
    public Book get(BookNumber isbn) {
        return null;
    }

    @Override
    public void delete(Book book) {

    }
}
