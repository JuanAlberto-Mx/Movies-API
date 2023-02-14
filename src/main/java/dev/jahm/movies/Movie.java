package dev.jahm.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

/**
 * <code>Movie</code> class represents each document in the <code>movies</code> collection.
 */
@Document(collection = "movies") // Establishes the collection to use.
@Data // Generates getter and setter methods for each field.
@AllArgsConstructor // Generates a constructor based on the fields declared in the class.
@NoArgsConstructor // Generates a default constructor without parameters.
public class Movie {

    @Id
    private ObjectId id;

    private String indbId;

    private String title;

    private String releaseDate;

    private String trailerLink;

    private String poster;

    private List<String> genres;

    private List<String> backdrops;

    @DocumentReference
    private List<Review> reviewIds;
}