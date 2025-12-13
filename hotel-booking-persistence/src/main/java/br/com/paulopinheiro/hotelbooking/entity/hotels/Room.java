package br.com.paulopinheiro.hotelbooking.entity.hotels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne @JoinColumn(name="hotel_id", referencedColumnName="id", nullable=false)
    private Hotel hotel;
    @NotNull
    @ManyToOne @JoinColumn(name="roomt_type_id", referencedColumnName="id", nullable=false)
    private RoomType roomType;
    @NotNull @Size(min=1, max=5)
    private String num;
    @NotNull @Size(min=1, max=6)
    private String floor;
    @NotNull @Min(0)
    @Column(name="price_per_night", nullable=false)
    private BigDecimal pricePerNight;
    @NotNull
    private Boolean available;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Hotel getHotel() {return hotel;}
    public void setHotel(Hotel hotel) {this.hotel = hotel;}

    public RoomType getRoomType() {return roomType;}
    public void setRoomType(RoomType roomType) {this.roomType = roomType;}

    public String getNum() {return num;}
    public void setNum(String num) {this.num = num;}

    public String getFloor() {return floor;}
    public void setFloor(String floor) {this.floor = floor;}

    public BigDecimal getPricePerNight() {return pricePerNight;}
    public void setPricePerNight(BigDecimal pricePerNight) {this.pricePerNight = pricePerNight;}

    public Boolean getAvailable() {return available;}
    public void setAvailable(Boolean available) {this.available = available;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof Room other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return "Room " + num + " from " + hotel + ", " + floor + " floor";
    }
}
