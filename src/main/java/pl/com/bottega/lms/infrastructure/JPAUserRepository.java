package pl.com.bottega.lms.infrastructure;


import pl.com.bottega.lms.model.User;
import pl.com.bottega.lms.model.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPAUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void put(User user) {
        entityManager.persist(user);
    }

    @Override
    public User get(Long userId) {
        return entityManager.find(User.class, userId);
    }
}
