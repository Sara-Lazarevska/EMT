package finki.ukim.mk.emt.model.DisplayDto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CountryDTO {
    private Long id;
    private String name;
    private String continent;

    public CountryDTO() {
    }

    public CountryDTO(Long id, String name, String continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
    }

    public CountryDTO(String name, String continent) {
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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}