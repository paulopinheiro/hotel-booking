package br.com.paulopinheiro.hotelbooking.customers.service.impl;

import br.com.paulopinheiro.hotelbooking.customers.service.CustomerService;
import br.com.paulopinheiro.hotelbooking.dao.customers.CustomerDao;
import br.com.paulopinheiro.hotelbooking.entity.customers.Customer;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class DefaultCustomerService implements CustomerService {
    @EJB private CustomerDao dao;

    @Override
    public List<Customer> getAllCustomers() {
        return dao.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        if (Optional.ofNullable(customer).isEmpty()) 
            throw new IllegalArgumentException("Customer can't be null");
        if (Optional.ofNullable(customer.getId()).isEmpty()) {
            dao.create(customer);
        } else {
            dao.edit(customer);
        }
    }

    @Override
    public void removeCustomer(Customer customer) {
        if (Optional.ofNullable(customer).isEmpty()) 
            throw new IllegalArgumentException("Customer can't be null");
        dao.remove(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        if (Optional.ofNullable(id).isEmpty())
            throw new IllegalArgumentException("Id can't be null");
        return dao.find(id);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return dao.findCustomerByEmail(email);
    }
}
