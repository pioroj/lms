package pl.com.bottega.lms.model;


import pl.com.bottega.lms.model.commands.AddBookCommand;
import pl.com.bottega.lms.model.commands.OrderBookCommand;
import pl.com.bottega.lms.model.commands.ReturnBookCommand;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @EmbeddedId
    private BookNumber number;

    private String title;
    private String author;
    private int year;
    private boolean available;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookNumber")
    private Set<Order> orders;

    Book() {}

    public Book(AddBookCommand cmd, NumberGenerator numberGenerator) {
        this.number = numberGenerator.generate();
        this.title = cmd.getTitle();
        this.author = cmd.getAuthor();
        this.year = cmd.getYear();
        this.available = true;
        this.orders = new HashSet<>();
    }

    public void orderBook(OrderBookCommand cmd) {
        this.available = false;
        Order order = getOrder(cmd.getUser());
        order.orderBook();
    }

    private Order getOrder(User user) {
        for (Order order : orders) {
            if (order.isOwnedBy(user)) {
                return order;
            }
        }
        throw new BookOrderException(String.format("No order for user %s", user));
    }

    public void returnBook(ReturnBookCommand cmd) {
        cmd.setReturnDate(LocalDateTime.now());
        this.available = true;
    }

    public BookNumber getNumber() {
        return number;
    }

    public void setNumber(BookNumber number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Set<Order> getOrders() {
        return Collections.unmodifiableSet(orders);
    }


}
