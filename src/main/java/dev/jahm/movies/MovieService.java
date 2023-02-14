package dev.jahm.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The <code>MovieService</code> class provides a set of wrapper methods
 * to access the functionality of the <code>MovieRepository</code>
 * interface and get the movies information directly from MongoDB.
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Gets all the movies from the collection.
     * @return the list of movies.
     */
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    /**
     * Gets a movie specified by an id.
     * @param imdbId the id of the movie.
     * @return the movie requested.
     */
    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByIndbId(imdbId);
    }
}
