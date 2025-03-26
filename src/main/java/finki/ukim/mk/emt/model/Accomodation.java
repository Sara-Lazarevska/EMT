package finki.ukim.mk.emt.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
public class Accomodation {
    @Id
    @GeneratedValue
    Long id;
    String name;
    @Enumerated(EnumType.STRING)
    Category category;
    @ManyToOne
    Host host;
    Integer numRooms;
    Boolean rented;

    public Accomodation() {
    }

    public Accomodation(Long id, String name, Category category, Host host, Integer numRooms, Boolean rented) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.rented = rented;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }
}
