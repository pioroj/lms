package pl.com.bottega.lms.model;


import java.time.LocalDate;
import java.util.Collection;

public class Book {

    private Isbn isbn;
    private String title;
    private Author author;
    private String description;
    private LocalDate publicationDate;
    private String publisher;
    private Collection<Genre> genres;
    private boolean availableToBorrow;
    private Long quantity;


}
