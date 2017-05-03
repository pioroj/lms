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

	@Embedded
	@AttributeOverride(name = "number", column = @Column(name = "bookNumber"))
    private BookNumber bookNumber;

    private LocalDateTime orderDate;
    private LocalDateTime returnDate;

    Loan() {}

    public Loan(User borrower, BookNumber bookNumber) {
        this.borrower = borrower;
        this.bookNumber = bookNumber;
        this.orderDate = LocalDateTime.now();
    }

	public void endLoaning() {
		this.returnDate = LocalDateTime.now();
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

    public BookNumber getBookNumber() {
        return bookNumber;
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
        return bookNumber.equals(loan.bookNumber);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + borrower.hashCode();
        result = 31 * result + bookNumber.hashCode();
        return result;
    }
}
