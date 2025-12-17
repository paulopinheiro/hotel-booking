package br.com.paulopinheiro.hotelbooking.faces.customers;

import br.com.paulopinheiro.hotelbooking.customers.service.CustomerService;
import br.com.paulopinheiro.hotelbooking.entity.customers.Customer;
import br.com.paulopinheiro.hotelbooking.faces.common.BasicMB;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Named
@ViewScoped
public class CustomerMB extends BasicMB<Customer> implements Serializable {
    private static final String TITLE = "Customer Registration";
    @EJB private CustomerService service;
    
    @Override
    public boolean isNewEntity() {
        return Optional.ofNullable(this.getEntity().getId()).isEmpty();
    }

    @Override
    protected void saveEntity(Customer customer) {service.saveCustomer(customer);}

    @Override
    protected void deleteEntity(Customer customer) {service.removeCustomer(customer);}

    @Override
    public List<Customer> getList() {return service.getAllCustomers();}

    @Override
    protected Customer newEntityInstance() {return new Customer();}

    public Customer getCustomer() {return this.getEntity();}
    public void setCustomer(Customer customer) {this.setEntity(customer);}

    public String getTitle() {
        return TITLE;
    }
}
