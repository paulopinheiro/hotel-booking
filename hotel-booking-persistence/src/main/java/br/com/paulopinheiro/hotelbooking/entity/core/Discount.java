package br.com.paulopinheiro.hotelbooking.entity.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Discount implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull @Size(min=1, max=50)
    @Column(unique=true)
    private String code;
    @NotNull @Min(0)
    private BigDecimal percentage;
    @Column(name="expiry_date")
    private LocalDate expiryDate;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}

    public BigDecimal getPercentage() {return percentage;}
    public void setPercentage(BigDecimal percentage) {this.percentage = percentage;}

    public LocalDate getExpiryDate() {return expiryDate;}
    public void setExpiryDate(LocalDate expiryDate) {this.expiryDate = expiryDate;}

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
        return code;
    }
}
