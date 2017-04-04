package pl.com.bottega.lms.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Loan {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BORROWER_ID")
    private User borrower;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    private LocalDateTime orderDate;
    private LocalDateTime returnDate;

    Loan() {}

    public Loan(User borrower, Book book) {
        this.borrower = borrower;
        this.book = book;
        this.orderDate = LocalDateTime.now();
    }

    public boolean isOrdered() {
        return orderDate.isBefore(LocalDateTime.now()) && returnDate == null;
    }

    public boolean isOwnedBy(User user) {
        return borrower.equals(user);
    }

    public Long getId() {
        return id;
    }

    public User getBorrower() {
        return borrower;
    }

    public Book getBook() {
        return book;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;

        Loan loan = (Loan) o;

        if (!id.equals(loan.id)) return false;
        if (!borrower.equals(loan.borrower)) return false;
        return book.equals(loan.book);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + borrower.hashCode();
        result = 31 * result + book.hashCode();
        return result;
    }
}
