package pl.com.bottega.lms.infrastructure;


import pl.com.bottega.lms.application.*;
import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.BookNumber;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Transactional
public class JPABookCatalog implements BookCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BookSearchResults find(BookQuery bookQuery) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		BookSearchResults results = new BookSearchResults();

		CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
		Root<Book> root = criteriaQuery.from(Book.class);
		Set<Predicate> predicates = createPredicates(bookQuery, criteriaBuilder, root);
		criteriaQuery.where(predicates.toArray(new Predicate[]{}));
		Query query = entityManager.createQuery(criteriaQuery);
		List<Book> books = query.getResultList();

		List<BookDto> bookDtos = new LinkedList<>();
		for (Book book : books) {
			bookDtos.add(createBookDto(book));
		}

		results.setBooks(bookDtos);

		return results;
    }

	private BookDto createBookDto(Book book) {
		BookDto bookDto = new BookDto();
		bookDto.setAvailable(book.isAvailable());
		bookDto.setTitle(book.getTitle());
		bookDto.setNumber(book.getNumber().toString());
		return bookDto;
	}

	private Set<Predicate> createPredicates(BookQuery bookQuery, CriteriaBuilder criteriaBuilder, Root<Book> root) {
		Set<Predicate> predicates = new HashSet<>();
		if (bookQuery.getPhrase() != null) {
			String likeExpression = "%" + bookQuery.getPhrase() + "%";
			predicates.add(criteriaBuilder.or(
					criteriaBuilder.like(root.get("title"), likeExpression),
					criteriaBuilder.like(root.get("author"), likeExpression)
			));
		}
		return predicates;
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
