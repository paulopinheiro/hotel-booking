package br.com.paulopinheiro.hotelbooking.entity.core;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Tax implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private BigDecimal percentage;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public BigDecimal getPercentage() {return percentage;}
    public void setPercentage(BigDecimal percentage) {this.percentage = percentage;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof Tax other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
