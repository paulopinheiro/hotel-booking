package br.com.paulopinheiro.hotelbooking.entity.core;

import br.com.paulopinheiro.hotelbooking.entity.core.enumeration.BookingStatus;
import br.com.paulopinheiro.hotelbooking.entity.customers.Customer;
import br.com.paulopinheiro.hotelbooking.entity.hotels.Room;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne @JoinColumn(name="customer_id", referencedColumnName="id", nullable=false)
    private Customer customer;
    @NotNull
    @ManyToOne @JoinColumn(name="room_id", referencedColumnName="id", nullable=false)
    private Room room;
    @NotNull
    @Column(name="check_in_date", nullable=false)
    private LocalDate checkInDate;
    @NotNull
    @Column(name="check_out_date", nullable=false)
    private LocalDate checkOutDate;
    @NotNull @Min(0)
    @Column(name="total_price", nullable=false)
    private BigDecimal totalPrice;
    @Enumerated (EnumType.STRING)
    private BookingStatus status;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "booking_tax",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "tax_id")
    )
    private List<Tax> taxesList;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "applied_discount",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "discount_id")
    )
    private List<Discount> appliedDiscountsList;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiceOrder> serviceOrdersList;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer customer) {this.customer = customer;}

    public Room getRoom() {return room;}
    public void setRoom(Room room) {this.room = room;}

    public LocalDate getCheckInDate() {return checkInDate;}
    public void setCheckInDate(LocalDate checkInDate) {this.checkInDate = checkInDate;}

    public LocalDate getCheckOutDate() {return checkOutDate;}
    public void setCheckOutDate(LocalDate checkOutDate) {this.checkOutDate = checkOutDate;}

    public BigDecimal getTotalPrice() {return totalPrice;}
    public void setTotalPrice(BigDecimal totalPrice) {this.totalPrice = totalPrice;}

    public BookingStatus getStatus() {return status;}
    public void setStatus(BookingStatus status) {this.status = status;}

    public List<Tax> getTaxesList() {return taxesList;}
    public void setTaxesList(List<Tax> taxesList) {this.taxesList = taxesList;}

    public List<Discount> getAppliedDiscountsList() {return appliedDiscountsList;}
    public void setAppliedDiscountsList(List<Discount> appliedDiscountsList) {this.appliedDiscountsList = appliedDiscountsList;}

    public List<ServiceOrder> getServiceOrdersList() {return serviceOrdersList;}
    public void setServiceOrdersList(List<ServiceOrder> serviceOrdersList) {this.serviceOrdersList = serviceOrdersList;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof Booking other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return "Booking " + room + " for " + customer;
    }
}
