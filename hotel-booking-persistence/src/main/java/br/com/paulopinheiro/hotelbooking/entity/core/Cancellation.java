package br.com.paulopinheiro.hotelbooking.entity.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Cancellation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne @JoinColumn(name="booking_id", referencedColumnName="id", nullable=false)
    private Booking booking;
    @NotNull @Size(min=1, max=32672)
    private String reason;
    @NotNull
    @Column(name="cancellation_date", nullable=false)
    private LocalDateTime cancellationDate;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Booking getBooking() {return booking;}
    public void setBooking(Booking booking) {this.booking = booking;}

    public String getReason() {return reason;}
    public void setReason(String reason) {this.reason = reason;}

    public LocalDateTime getCancellationDate() {return cancellationDate;}
    public void setCancellationDate(LocalDateTime cancellationDate) {this.cancellationDate = cancellationDate;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof Cancellation other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return "Cancellation of " + booking + " at " + cancellationDate.toString();
    }
}
