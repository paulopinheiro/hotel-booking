package br.com.paulopinheiro.hotelbooking.entity.hotels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull @Size(min=1,max=255)
    private String name;
    @NotNull @Size(min=1,max=255)
    private String location;
    @Size(max=32672)
    private String description;
    @Min(1) @Max(5)
    @Column(name="star_rating")
    private BigDecimal starRating;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
    @Column(name="contact_email")
    private String contactEmail;
    @Column(name="contact_phone")
    private String contactPhone;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public BigDecimal getStarRating() {return starRating;}
    public void setStarRating(BigDecimal starRating) {this.starRating = starRating;}

    public String getContactEmail() {return contactEmail;}
    public void setContactEmail(String contactEmail) {this.contactEmail = contactEmail;}

    public String getContactPhone() {return contactPhone;}
    public void setContactPhone(String contactPhone) {this.contactPhone = contactPhone;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (Optional.ofNullable(object).isEmpty()) return false;

        if (object instanceof Hotel other)
            return Objects.equals(this.getId(), other.getId());

        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}