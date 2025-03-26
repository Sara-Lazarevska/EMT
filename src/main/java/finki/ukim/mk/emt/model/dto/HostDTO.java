package finki.ukim.mk.emt.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class HostDTO {

    String name;
    String surname;
    Long countryID;

    public HostDTO() {
    }

    public HostDTO(String name, String surname, Long countryID) {
        this.name = name;
        this.surname = surname;
        this.countryID = countryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getCountryID() {
        return countryID;
    }

    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }
}
