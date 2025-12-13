package br.com.paulopinheiro.hotelbooking.entity.core;

import br.com.paulopinheiro.hotelbooking.entity.hotels.Service;
import jakarta.persistence.Column;
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
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name="service_order")
public class ServiceOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne @JoinColumn(name="booking_id", referencedColumnName="id", nullable=false)
    private Booking booking;
    @NotNull
    @ManyToOne @JoinColumn(name="service_id", referencedColumnName="id", nullable=false)
    private Service service;
    @NotNull @Min(1)
    private Integer quantity;
    @NotNull @Min(0)
    @Column(name="total_price", nullable=false)
    private BigDecimal totalPrice;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Booking getBooking() {return booking;}
    public void setBooking(Booking booking) {this.booking = booking;}

    public Service getService() {return service;}
    public void setService(Service service) {this.service = service;}

    public Integer getQuantity() {return quantity;}
    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public BigDecimal getTotalPrice() {return totalPrice;}
    public void setTotalPrice(BigDecimal totalPrice) {this.totalPrice = totalPrice;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof ServiceOrder other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return "Service Order of " + service + " for " + booking + " (quantity: " + quantity + ")";
    }
}
