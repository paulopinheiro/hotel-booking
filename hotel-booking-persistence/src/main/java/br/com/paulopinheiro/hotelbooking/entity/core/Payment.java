package br.com.paulopinheiro.hotelbooking.entity.core;

import br.com.paulopinheiro.hotelbooking.entity.core.enumeration.PaymentMethod;
import br.com.paulopinheiro.hotelbooking.entity.core.enumeration.PaymentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne @JoinColumn(name="booking_id", referencedColumnName="id", nullable=false)
    private Booking booking;
    @NotNull @DecimalMin("0.01")
    private BigDecimal amount;
    @NotNull
    @Column(name="payment_date", nullable=false)
    private LocalDate paymentDate;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentMethod method;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Booking getBooking() {return booking;}
    public void setBooking(Booking booking) {this.booking = booking;}

    public BigDecimal getAmount() {return amount;}
    public void setAmount(BigDecimal amount) {this.amount = amount;}

    public LocalDate getPaymentDate() {return paymentDate;}
    public void setPaymentDate(LocalDate paymentDate) {this.paymentDate = paymentDate;}

    public PaymentMethod getMethod() {return method;}
    public void setMethod(PaymentMethod method) {this.method = method;}

    public PaymentStatus getStatus() {return status;}
    public void setStatus(PaymentStatus status) {this.status = status;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof Payment other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return "Payment for " + booking + " (date: " + paymentDate.toString();
    }
}
