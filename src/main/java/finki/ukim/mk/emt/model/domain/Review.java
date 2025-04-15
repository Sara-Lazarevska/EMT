package finki.ukim.mk.emt.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    @GeneratedValue
    Long id;
    String comment;
    Integer rating;
    @ManyToOne
    Accommodation accommodation;

    public Review(Long id, String comment, Integer rating, Accommodation accommodation) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
        this.accommodation = accommodation;
    }

    public Review() {
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

    public Accommodation getAccomodation() {
        return accommodation;
    }

    public void setAccomodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
}
