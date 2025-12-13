package br.com.paulopinheiro.hotelbooking.entity.customers;

import br.com.paulopinheiro.hotelbooking.entity.customers.enumeration.SupportRequestStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name="support_request")
public class SupportRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne @JoinColumn(name="customer_id", referencedColumnName="id", nullable=false)
    private Customer customer;
    @NotNull @Size(min=1, max=32672)
    private String issue;
    @NotNull
    @Enumerated(EnumType.STRING)
    private SupportRequestStatus status;
    @NotNull
    @Column(name="created_at", nullable=false)
    private Timestamp createdAt;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer customer) {this.customer = customer;}

    public String getIssue() {return issue;}
    public void setIssue(String issue) {this.issue = issue;}

    public SupportRequestStatus getStatus() {return status;}
    public void setStatus(SupportRequestStatus status) {this.status = status;}

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

        if (object instanceof SupportRequest other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return "Support Request[ id=" + id + " ] from " + customer;
    }
}
