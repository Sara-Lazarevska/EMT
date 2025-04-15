package finki.ukim.mk.emt.service;

import finki.ukim.mk.emt.model.domain.Review;

import java.util.List;
import java.util.OptionalDouble;

public interface ReviewService {
    List<Review> getAllReviews(Long accomodationID);
    Review addNewReview(Long accomodationID);
    OptionalDouble averageRating(Long accomodationID);
}
