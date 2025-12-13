package br.com.paulopinheiro.hotelbooking.entity.customers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    @ManyToOne @JoinColumn(name="customer_id", referencedColumnName="id", nullable=false)
    private Customer customer;
    @NotNull @Size(min=1, max=32672)
    private String message;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer customer) {this.customer = customer;}

    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof Feedback other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return "Feedback[ id=" + id + " ] from " + customer;
    }
}
