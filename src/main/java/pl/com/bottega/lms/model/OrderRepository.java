package pl.com.bottega.lms.model;


public interface OrderRepository {

    void put(Loan loan);

    Loan get(Long orderId);

    Loan findOrderBy(User borrower, Book book);

}
