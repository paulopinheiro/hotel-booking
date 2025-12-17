package br.com.paulopinheiro.hotelbooking.customers.service;

import br.com.paulopinheiro.hotelbooking.entity.customers.Feedback;
import java.util.List;

public interface FeedbackService {
    List<Feedback> getAllFeedbacks();
    void saveFeedback(Feedback feedback);
    void removeFeedback(Feedback feedback);
    Feedback getFeedbackById(Integer id);
}
