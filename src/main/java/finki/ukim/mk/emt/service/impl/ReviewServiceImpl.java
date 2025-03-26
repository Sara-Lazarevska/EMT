package finki.ukim.mk.emt.service.impl;

import finki.ukim.mk.emt.model.Accomodation;
import finki.ukim.mk.emt.model.Review;
import finki.ukim.mk.emt.repository.AccomodationRepository;
import finki.ukim.mk.emt.repository.ReviewRepository;
import finki.ukim.mk.emt.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final AccomodationRepository accomodationRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, AccomodationRepository accomodationRepository) {
        this.reviewRepository = reviewRepository;
        this.accomodationRepository = accomodationRepository;
    }

    @Override
    public List<Review> getAllReviews(Long accomodationID) {
       return reviewRepository.findReviewsByAccomodationId(accomodationID);
    }

    @Override
    public Review addNewReview(Long accomodationID) {
        Accomodation accomodation = accomodationRepository.findById(accomodationID).orElseThrow(RuntimeException::new);
        Review review = new Review();
        review.setAccomodation(accomodation);
        review.setComment(review.getComment());
        review.setRating(review.getRating());
        return reviewRepository.save(review);
    }

    @Override
    public OptionalDouble averageRating(Long accomodationID) {
        List<Review> reviews = reviewRepository.findReviewsByAccomodationId(accomodationID);
        return reviews.stream().mapToDouble(Review::getRating).average();
    }
}
