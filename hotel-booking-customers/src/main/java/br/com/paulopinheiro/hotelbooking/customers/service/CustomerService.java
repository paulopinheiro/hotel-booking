package br.com.paulopinheiro.hotelbooking.customers.service;

import br.com.paulopinheiro.hotelbooking.entity.customers.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void saveCustomer(Customer customer);
    void removeCustomer(Customer customer);
    Customer getCustomerById(Integer id);
    Customer getCustomerByEmail(String email);
}
