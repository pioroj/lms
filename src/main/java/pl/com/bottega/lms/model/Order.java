package pl.com.bottega.lms.model;


import java.time.LocalDateTime;

public class Order {

    private Long id;
    private User borrower;
    private LocalDateTime orderDate;
    private LocalDateTime returnDate;

    public Order(User borrower) {
        this.borrower = borrower;
    }

    public void orderBook() {
        this.orderDate = LocalDateTime.now();
    }

    public void returnBook() {
        this.returnDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public User getBorrower() {
        return borrower;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }
}
