package finki.ukim.mk.emt.repository;

import finki.ukim.mk.emt.model.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewsByAccommodationId(Long accomodationID);
}
