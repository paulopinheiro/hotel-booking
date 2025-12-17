package br.com.paulopinheiro.hotelbooking.faces.customers.converter;

import br.com.paulopinheiro.hotelbooking.entity.customers.Customer;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UISelectItems;
import jakarta.faces.component.UISelectOne;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import java.util.List;
import java.util.Optional;

@FacesConverter
public class CustomerConverter implements Converter<Customer> {

    @Override
    public Customer getAsObject(FacesContext context, UIComponent component, String value) {
        if (Optional.ofNullable(value).isEmpty()) return null;

        int id = Integer.parseInt(value);
        List<Customer> customerList = getListFromComponent((UISelectOne) component);

        return customerById(customerList, id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Customer customer) {
        if (Optional.ofNullable(customer).isEmpty()) return null;

        return Optional.ofNullable(customer.getId()).isPresent() ? String.valueOf(customer.getId()) : null;
    }

    private Customer customerById(List<Customer> customerList, int id) {
        Customer customer = null;

        for (Customer c : customerList) {
            if (c.getId() == id) {
                customer = c;
                break;
            }
        }
        return customer;
    }

    private List<Customer> getListFromComponent(UISelectOne selectOne) {
        UISelectItems customerSelectItems = null;

        for (UIComponent ui : selectOne.getChildren()) {
            if (ui instanceof UISelectItems uiSelectItems) {
                customerSelectItems = uiSelectItems;
                break;
            }
        }
        if (customerSelectItems == null) {
            throw new RuntimeException("Could not validate Customer object");
        }

        return (List<Customer>) customerSelectItems.getValue();
    }    
}
