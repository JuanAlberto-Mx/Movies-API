package dev.jahm.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The <code>ReviewRepository</code> interface encapsulates the methods necessary
 * to get information of a <code>Review</code> related to a particular movie
 * from the collection via MongoDB.
 */
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
