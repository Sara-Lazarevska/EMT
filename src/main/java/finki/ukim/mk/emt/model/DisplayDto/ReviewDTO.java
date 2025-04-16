package finki.ukim.mk.emt.model.DisplayDto;

public class ReviewDTO {
    private Long id;
    private String comment;
    private Integer rating;
    private Long accommodationId;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String comment, Integer rating, Long accommodationId) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
        this.accommodationId = accommodationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(Long accommodationId) {
        this.accommodationId = accommodationId;
    }
}