package finki.ukim.mk.emt.web;

import finki.ukim.mk.emt.model.DisplayDto.ReviewDTO;
import finki.ukim.mk.emt.model.domain.Review;
import finki.ukim.mk.emt.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.OptionalDouble;


@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Operation(summary = "Get all reviews for an accommodation")
    @GetMapping
    public List<ReviewDTO> getAllReviews(@RequestParam Long accommodationId) {
        return reviewService.getAllReviews(accommodationId);
    }

    @Operation(summary = "Add a new review to an accommodation")
    @PostMapping("/{accommodationId}")
    public ReviewDTO addReview(@PathVariable Long accommodationId,
                               @RequestBody ReviewDTO reviewDTO) {
        return reviewService.addNewReview(accommodationId, reviewDTO);
    }

    @Operation(summary = "Get average rating for an accommodation")
    @GetMapping("/{accommodationId}/avg")
    public OptionalDouble getAverageRating(@PathVariable Long accommodationId) {
        return reviewService.averageRating(accommodationId);
    }
}
