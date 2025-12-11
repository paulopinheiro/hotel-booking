package br.com.paulopinheiro.hotelbooking.dao.customers;

import br.com.paulopinheiro.hotelbooking.dao.AbstractDao;
import br.com.paulopinheiro.hotelbooking.entity.customers.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CustomerDao extends AbstractDao<Customer> {
    @PersistenceContext(unitName = "hotel-booking-pu") private EntityManager em;

    public CustomerDao() {
        super(Customer.class);
    }

    public Customer findCustomerByEmail(String email) {
        return this.getUniqueEqualStringAttribute("email", email);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
