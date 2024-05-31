package dev.ekli.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/reviews")   // make this to reviews
public class ReviewController {
    // One Post Method.
    @Autowired
    private ReviewService reviewService;

    @PostMapping    // post API endpoint    - Whatever we get as the requestBody, we want to create to a Map, key string, value string
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);  // Created 201
    }
}
