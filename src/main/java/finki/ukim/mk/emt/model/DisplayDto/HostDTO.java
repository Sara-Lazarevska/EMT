package finki.ukim.mk.emt.model.DisplayDto;


public class HostDTO {
    private Long id;
    private String name;
    private String surname;
    private Long countryId;

    public HostDTO() {
    }

    public HostDTO(Long id, String name, String surname, Long countryId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
    }

    public HostDTO(String name, String surname, Long id) {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}