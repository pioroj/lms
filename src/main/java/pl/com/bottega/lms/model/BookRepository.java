package pl.com.bottega.lms.model;


public interface BookRepository {

    void put(Book book);

    Book get(BookNumber bookNumber);

    void delete(Book book);

}
