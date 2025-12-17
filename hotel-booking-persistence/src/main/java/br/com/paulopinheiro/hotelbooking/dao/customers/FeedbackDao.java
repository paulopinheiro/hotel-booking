package br.com.paulopinheiro.hotelbooking.dao.customers;

import br.com.paulopinheiro.hotelbooking.dao.AbstractDao;
import br.com.paulopinheiro.hotelbooking.entity.customers.Feedback;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class FeedbackDao extends AbstractDao<Feedback> {
    @PersistenceContext(unitName = "hotel-booking-pu") private EntityManager em;

    public FeedbackDao() {
        super(Feedback.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}