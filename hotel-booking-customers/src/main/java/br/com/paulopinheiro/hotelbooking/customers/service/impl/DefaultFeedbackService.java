package br.com.paulopinheiro.hotelbooking.customers.service.impl;

import br.com.paulopinheiro.hotelbooking.customers.service.FeedbackService;
import br.com.paulopinheiro.hotelbooking.dao.customers.FeedbackDao;
import br.com.paulopinheiro.hotelbooking.entity.customers.Feedback;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class DefaultFeedbackService implements FeedbackService {
    @EJB private FeedbackDao dao;

    @Override
    public List<Feedback> getAllFeedbacks() {
        return dao.findAll();
    }

    @Override
    public void saveFeedback(Feedback feedback) {
        if (Optional.ofNullable(feedback).isEmpty()) 
            throw new IllegalArgumentException("Feedback can't be null");
        if (Optional.ofNullable(feedback.getId()).isEmpty()) {
            dao.create(feedback);
        } else {
            dao.edit(feedback);
        }
    }

    @Override
    public void removeFeedback(Feedback feedback) {
        if (Optional.ofNullable(feedback).isEmpty()) 
            throw new IllegalArgumentException("Feedback can't be null");
        dao.remove(feedback);
    }

    @Override
    public Feedback getFeedbackById(Integer id) {
        if (Optional.ofNullable(id).isEmpty())
            throw new IllegalArgumentException("Id can't be null");
        return dao.find(id);
    }
}
