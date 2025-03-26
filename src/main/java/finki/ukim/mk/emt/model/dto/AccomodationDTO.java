package finki.ukim.mk.emt.model.dto;

import finki.ukim.mk.emt.model.Category;
import finki.ukim.mk.emt.model.Host;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class AccomodationDTO {

    String name;
    String category;
    Long hostID;
    Integer numRooms;

    public AccomodationDTO(String name, String category, Long hostID, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.hostID = hostID;
        this.numRooms = numRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getHostID() {
        return hostID;
    }

    public void setHostID(Long hostID) {
        this.hostID = hostID;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }
}
