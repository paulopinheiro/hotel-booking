package br.com.paulopinheiro.hotelbooking.entity.customers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name="loyalty_program")
public class LoyaltyProgram implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne @JoinColumn(name="customer_id", referencedColumnName="id", nullable=false)
    private Customer customer;
    @NotNull @Min(0)
    private Integer points;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof LoyaltyProgram other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return customer + ": " + points + " points";
    }
}