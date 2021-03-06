package pl.com.bottega.lms.infrastructure;


import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class JPABookRepository implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void put(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book get(BookNumber bookNumber) {
        return entityManager.find(Book.class, bookNumber);
    }

    @Override
    public void delete(Book book) {

    }
}
