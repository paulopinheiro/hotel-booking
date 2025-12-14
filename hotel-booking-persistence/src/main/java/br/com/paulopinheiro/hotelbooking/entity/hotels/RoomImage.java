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
@Table(name="room_image")
public class RoomImage implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne @JoinColumn(name="room_type_id", referencedColumnName="id", nullable=false)
    private RoomType roomType;
    @NotNull @Size(min=1, max=255)
    private String url;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public RoomType getRoomType() {return roomType;}
    public void setRoomType(RoomType roomType) {this.roomType = roomType;}

    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof RoomImage other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return "Image for room type " + roomType;
    }
}
