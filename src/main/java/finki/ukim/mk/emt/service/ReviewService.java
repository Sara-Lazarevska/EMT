package finki.ukim.mk.emt.service;

import finki.ukim.mk.emt.model.DisplayDto.ReviewDTO;
import finki.ukim.mk.emt.model.domain.Review;

import java.util.List;
import java.util.OptionalDouble;

public interface ReviewService {
    List<ReviewDTO> getAllReviews(Long accommodationId);
    ReviewDTO addNewReview(Long accommodationId, ReviewDTO reviewDTO);
    OptionalDouble averageRating(Long accommodationId);
}
