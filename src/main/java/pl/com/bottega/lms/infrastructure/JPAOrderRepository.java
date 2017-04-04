package pl.com.bottega.lms.infrastructure;


import pl.com.bottega.lms.model.Loan;
import pl.com.bottega.lms.model.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class JPAOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void put(Loan loan) {
        entityManager.persist(loan);
    }
}
