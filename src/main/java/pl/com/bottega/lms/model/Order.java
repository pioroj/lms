package pl.com.bottega.lms.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "borrowerId"))
    private User borrower;

    private LocalDateTime orderDate;
    private LocalDateTime returnDate;

    Order() {}

    public Order(User borrower) {
        this.borrower = borrower;
    }

    public boolean isOrdered() {
        return orderDate.isBefore(LocalDateTime.now()) && returnDate == null;
    }

    public boolean isOwnedBy(User user) {
        return borrower.equals(user);
    }

    public void orderBook() {
        if (isOrdered()) {
            throw new BookOrderException("Book is not available at the moment");
        }
        this.orderDate = LocalDateTime.now();
    }

    public void returnBook() {
        this.returnDate = LocalDateTime.now();
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
