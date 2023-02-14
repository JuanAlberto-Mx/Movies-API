package dev.jahm.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * The <code>ReviewService</code> class provides a set of wrapper methods
 * to access the functionality of the <code>ReviewRepository</code>
 * interface and get the reviews directly from MongoDB.
 */
@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * Creates a review for a specific movie by using its <code>id</code>.
     * @param reviewBody the text of the review.
     * @param imdbId the movie id to set the review.
     * @return the instance of the new review.
     */
    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
