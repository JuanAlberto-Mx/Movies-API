package dev.jahm.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The <code>MovieRepository</code> interface encapsulates the methods necessary
 * to get information from the <code>Movie</code> collection establishing a direct
 * relation with MongoDB.
 */
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    /**
     * Gets a particular movie by specifying an id value.
     * @param imdbId the id of the movie.
     * @return the information of the movie in case of existing.
     */
    Optional<Movie> findMovieByIndbId(String imdbId);
}