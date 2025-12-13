package br.com.paulopinheiro.hotelbooking.entity.hotels;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name="hotel_facility")
public class HotelFacility implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne @JoinColumn(name="hotel_id", referencedColumnName="id", nullable=false)
    private Hotel hotel;
    @NotNull @Size(min=1, max=255)
    private String name;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Hotel getHotel() {return hotel;}
    public void setHotel(Hotel hotel) {this.hotel = hotel;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof HotelFacility other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return name + " (" + hotel + ")";
    }
}
