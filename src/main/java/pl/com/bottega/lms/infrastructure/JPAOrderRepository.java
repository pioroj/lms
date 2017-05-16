package pl.com.bottega.lms.infrastructure;


import pl.com.bottega.lms.model.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class JPAOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void put(Loan loan) {
        entityManager.persist(loan);
    }

    @Override
    public Loan get(Long orderId) {
        return entityManager.find(Loan.class, orderId);
    }

    @Override
    public Loan findOrderBy(User borrower, BookNumber bookNumber) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Loan> criteriaQuery = cb.createQuery(Loan.class);
        Root<Loan> root = criteriaQuery.from(Loan.class);

        criteriaQuery.select(root).where(cb.and(
                cb.equal(root.get("borrower").get("id"), borrower.getId()),
                cb.equal(root.get("bookNumber"), bookNumber),
                cb.isNull(root.get("returnDate"))
        ));
        TypedQuery<Loan> query = entityManager.createQuery(criteriaQuery);

        List<Loan> loans = query.getResultList();
        if (loans.size() == 0)
            return null;
        else
            return loans.get(0);
    }


}
