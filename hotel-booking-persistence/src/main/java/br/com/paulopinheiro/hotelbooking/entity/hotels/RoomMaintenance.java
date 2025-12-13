package br.com.paulopinheiro.hotelbooking.entity.hotels;

import br.com.paulopinheiro.hotelbooking.entity.hotels.enumeration.RoomMaintenanceStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="room_maintenance")
public class RoomMaintenance implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne @JoinColumn(name="room_id", referencedColumnName="id", nullable=false)
    private Room room;
    @Size(max=3672)
    private String issueDescription;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoomMaintenanceStatus status;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Room getRoom() {return room;}
    public void setRoom(Room room) {this.room = room;}

    public String getIssueDescription() {return issueDescription;}
    public void setIssueDescription(String issueDescription) {this.issueDescription = issueDescription;}

    public RoomMaintenanceStatus getStatus() {return status;}
    public void setStatus(RoomMaintenanceStatus status) {this.status = status;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof RoomMaintenance other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return "Room maintenance id: " + id;
    }
}
