package pl.com.bottega.lms.model;


import pl.com.bottega.lms.model.commands.AddBookCommand;

import javax.persistence.*;

@Entity
public class Book {

    @EmbeddedId
    private BookNumber number;

    private String title;
    private String author;
    private int year;
    private boolean available;

    Book() {}

    public Book(AddBookCommand cmd) {
        this.number = new BookNumber();
        this.title = cmd.getTitle();
        this.author = cmd.getAuthor();
        this.year = cmd.getYear();
        this.available = true;
    }

    public void orderBook() {
        if (!isAvailable())
            throw new BookOrderException(String.format("Book %s is not available.", this.title));
        this.available = false;
    }

    public void returnBook() {
        if (isAvailable())
            throw new BookOrderException(String.format("Cannot return book %s.", this.title));
        this.available = true;
    }

    public BookNumber getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }
}
