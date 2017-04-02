package pl.com.bottega.lms.model;


import pl.com.bottega.lms.model.commands.AddBookCommand;
import pl.com.bottega.lms.model.commands.OrderBookCommand;
import pl.com.bottega.lms.model.commands.ReturnBookCommand;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Book {

    @EmbeddedId
    private BookNumber number;

    private String title;
    private String author;
    private int year;
    private boolean available;

    Book() {}

    public Book(AddBookCommand cmd, NumberGenerator numberGenerator) {
        this.number = numberGenerator.generate();
        this.title = cmd.getTitle();
        this.author = cmd.getAuthor();
        this.year = cmd.getYear();
        this.available = true;
    }

    public void orderBook(OrderBookCommand cmd) {
        this.available = false;
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

}
