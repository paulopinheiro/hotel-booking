package br.com.paulopinheiro.hotelbooking.dao.customers;

import br.com.paulopinheiro.hotelbooking.dao.AbstractDao;
import br.com.paulopinheiro.hotelbooking.entity.customers.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;

public class CustomerDao extends AbstractDao<Customer> {
    @PersistenceContext(unitName = "aviano-pu") private EntityManager em;

    public CustomerDao(Class<Customer> customer) {
        super(customer);
    }

    public void save(Customer customer) {
        if (Optional.ofNullable(customer).isEmpty()) 
            throw new IllegalArgumentException("Customer can't be null");
        if (Optional.ofNullable(customer.getId()).isEmpty()) {
            create(customer);
        } else {
            edit(customer);
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
