package br.com.paulopinheiro.hotelbooking.faces.customers;

import br.com.paulopinheiro.hotelbooking.customers.service.FeedbackService;
import br.com.paulopinheiro.hotelbooking.entity.customers.Feedback;
import br.com.paulopinheiro.hotelbooking.faces.common.BasicMB;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public class FeedbackMB extends BasicMB<Feedback> implements Serializable {
    private static final String TITLE = "Feedback Page";
    @EJB private FeedbackService service;

    public FeedbackMB() {}

    @Override
    public boolean isNewEntity() {
        return Optional.ofNullable(this.getEntity().getId()).isEmpty();
    }

    @Override
    protected void saveEntity(Feedback feedback) {service.saveFeedback(feedback);}

    @Override
    protected void deleteEntity(Feedback feedback) {service.removeFeedback(feedback);}

    @Override
    public List<Feedback> getList() {return service.getAllFeedbacks();}

    @Override
    protected Feedback newEntityInstance() {
        return new Feedback();
    }

    public String getTitle() {
        return TITLE;
    }
}
