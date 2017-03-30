package pl.com.bottega.lms.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "borrower"))
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
