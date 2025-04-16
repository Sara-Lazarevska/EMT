package finki.ukim.mk.emt.service.impl;

import finki.ukim.mk.emt.model.DisplayDto.ReviewDTO;
import finki.ukim.mk.emt.model.domain.Accommodation;
import finki.ukim.mk.emt.model.domain.Review;
import finki.ukim.mk.emt.repository.AccommodationRepository;
import finki.ukim.mk.emt.repository.ReviewRepository;
import finki.ukim.mk.emt.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service

public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final AccommodationRepository accommodationRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, AccommodationRepository accommodationRepository) {
        this.reviewRepository = reviewRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public List<ReviewDTO> getAllReviews(Long accommodationId) {
        return reviewRepository.findAllByAccommodationId(accommodationId)
                .stream()
                .map(review -> new ReviewDTO(
                        review.getId(),
                        review.getComment(),
                        review.getRating(),
                        review.getAccomodation().getId()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDTO addNewReview(Long accommodationId, ReviewDTO reviewDTO) {
        Accommodation accommodation = accommodationRepository.findById(accommodationId)
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));

        Review review = new Review();
        review.setComment(reviewDTO.getComment());
        review.setRating(reviewDTO.getRating());
        review.setAccomodation(accommodation);

        Review saved = reviewRepository.save(review);

        return new ReviewDTO(saved.getId(), saved.getComment(), saved.getRating(), saved.getAccomodation().getId());
    }

    @Override
    public OptionalDouble averageRating(Long accommodationId) {
        return reviewRepository.findAllByAccommodationId(accommodationId)
                .stream()
                .mapToInt(Review::getRating)
                .average();
    }
}

