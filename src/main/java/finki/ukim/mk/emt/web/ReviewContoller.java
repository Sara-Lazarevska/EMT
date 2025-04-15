package finki.ukim.mk.emt.web;

import finki.ukim.mk.emt.model.domain.Review;
import finki.ukim.mk.emt.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/api/reviews")
public class ReviewContoller {
    private final ReviewService reviewService;

    public ReviewContoller(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public List<Review> getAllReviews(@RequestParam Long accomodationID){
       return reviewService.getAllReviews(accomodationID);
    }
    @PostMapping("{id}")
    public Review add(@PathVariable Long id){
        return reviewService.addNewReview(id);
    }
    @GetMapping("/{id}/avg")
    public OptionalDouble avgRating(@PathVariable Long id){
        return reviewService.averageRating(id);
    }

}
