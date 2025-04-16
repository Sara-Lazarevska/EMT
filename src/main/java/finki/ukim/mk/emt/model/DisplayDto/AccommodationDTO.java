package finki.ukim.mk.emt.model.DisplayDto;

import finki.ukim.mk.emt.model.enumerations.Category;

public class AccommodationDTO {
    private Long id;
    private String name;
    private Category category;
    private Long hostId;
    private Integer numRooms;
    private Integer rented;
    private String comment;

    public AccommodationDTO() {
    }

    public AccommodationDTO(Long id, String name, Category category, Long hostId, Integer numRooms, Integer rented, String comment) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.hostId = hostId;
        this.numRooms = numRooms;
        this.rented = rented;
        this.comment = comment;
    }

    public AccommodationDTO(String name, String name1, Long id, Integer numRooms) {
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

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

    public Integer getRented() {
        return rented;
    }

    public void setRented(Integer rented) {
        this.rented = rented;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
