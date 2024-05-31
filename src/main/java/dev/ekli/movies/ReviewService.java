package dev.ekli.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired  // allows for the POST to the database
    private ReviewRepository reviewRepository;

    @Autowired  // update to the movie class
    private MongoTemplate mongoTemplate;

    // Look for movie with imdbID, and associate a new review with that imdbID
    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));    // insert return data you pushed into database

        // Using template make an update on the movie class.
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review.getId()))
                .first();
        return review;
    }
}
