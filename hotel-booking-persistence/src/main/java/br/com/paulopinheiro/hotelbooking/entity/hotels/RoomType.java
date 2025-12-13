package br.com.paulopinheiro.hotelbooking.entity.hotels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name="room_type")
public class RoomType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull @Size(min=1, max=100)
    private String name;
    @NotNull @Size(min=1, max=255)
    private String description;
    @NotNull @DecimalMin("0.01")
    @Column(name="base_rate", nullable=false)
    private BigDecimal baseRate;
    @NotNull @Min(1)
    @Column(name="max_occupancy", nullable=false)
    private Integer maxOccupancy;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public BigDecimal getBaseRate() {return baseRate;}
    public void setBaseRate(BigDecimal baseRate) {this.baseRate = baseRate;}

    public Integer getMaxOccupancy() {return maxOccupancy;}
    public void setMaxOccupancy(Integer maxOccupancy) {this.maxOccupancy = maxOccupancy;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof RoomType other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
