package br.com.paulopinheiro.hotelbooking.entity.customers;

import br.com.paulopinheiro.hotelbooking.entity.customers.enumeration.NotificationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne @JoinColumn(name="customer_id", referencedColumnName="id", nullable=false)
    private Customer customer;
    @NotNull @Size(min=1, max=32672)
    private String message;
    @NotNull
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;
    @NotNull
    @Column(name="created_at", nullable=false)
    private Timestamp createdAt;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer customer) {this.customer = customer;}

    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    public NotificationStatus getStatus() {return status;}
    public void setStatus(NotificationStatus status) {this.status = status;}

    public Timestamp getCreatedAt() {return createdAt;}
    public void setCreatedAt(Timestamp createdAt) {this.createdAt = createdAt;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof Notification other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return "Notification[ id=" + id + " ] to Customer " + customer;
    }
}
