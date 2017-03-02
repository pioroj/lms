package pl.com.bottega.lms.model;


import java.time.LocalDate;

public class Order {

    private Long id;
    private User borrower;
    private Book book;
    private LocalDate orderDate;
    private LocalDate returnDate;

}
