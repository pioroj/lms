package pl.com.bottega.lms.infrastructure;


import pl.com.bottega.lms.application.*;
import pl.com.bottega.lms.model.Book;
import pl.com.bottega.lms.model.BookNumber;
import pl.com.bottega.lms.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class JPABookCatalog implements BookCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BookSearchResults find(BookQuery bookQuery) {
        return null;
    }

    @Override
    public BookDto get(BookNumber bookNumber) {
        Query query = entityManager.createQuery("SELECT b FROM Book b LEFT JOIN FETCH b.orders WHERE b.number = :nr");
        query.setParameter("nr", bookNumber);
        Book book = (Book) query.getResultList().get(0);

        BookDto bookDto = new BookDto();
        bookDto.setNumber(bookNumber.getNumber());
        bookDto.setTitle(book.getTitle());
        bookDto.setAvailable(book.isAvailable());

        List<OrderDto> orderDtos = new LinkedList<>();
        for (Order order : book.getOrders()) {
            OrderDto orderDto = createOrderDto(order);
            orderDtos.add(orderDto);
        }

        bookDto.setOrders(orderDtos);
        return bookDto;
    }

    private OrderDto createOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setUserId(order.getBorrower().getId());
        orderDto.setOrderedAt(order.getOrderDate());
        orderDto.setReturnedAt(order.getReturnDate());
        return orderDto;
    }

}
