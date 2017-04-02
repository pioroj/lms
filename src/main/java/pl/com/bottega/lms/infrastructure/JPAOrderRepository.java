package pl.com.bottega.lms.infrastructure;


import pl.com.bottega.lms.model.Order;
import pl.com.bottega.lms.model.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class JPAOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void put(Order order) {
        entityManager.persist(order);
    }
}
