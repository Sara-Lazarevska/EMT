package finki.ukim.mk.emt.service.impl;

import finki.ukim.mk.emt.model.domain.Accommodation;
import finki.ukim.mk.emt.model.domain.Review;
import finki.ukim.mk.emt.repository.AccommodationRepository;
import finki.ukim.mk.emt.repository.ReviewRepository;
import finki.ukim.mk.emt.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final AccommodationRepository accommodationRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, AccommodationRepository accommodationRepository) {
        this.reviewRepository = reviewRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public List<Review> getAllReviews(Long accomodationID) {
       return reviewRepository.findReviewsByAccommodationId(accomodationID);
    }

    @Override
    public Review addNewReview(Long accomodationID) {
        Accommodation accommodation = accommodationRepository.findById(accomodationID).orElseThrow(RuntimeException::new);
        Review review = new Review();
        review.setAccomodation(accommodation);
        review.setComment(review.getComment());
        review.setRating(review.getRating());
        return reviewRepository.save(review);
    }

    @Override
    public OptionalDouble averageRating(Long accomodationID) {
        List<Review> reviews = reviewRepository.findReviewsByAccommodationId(accomodationID);
        return reviews.stream().mapToDouble(Review::getRating).average();
    }
}
