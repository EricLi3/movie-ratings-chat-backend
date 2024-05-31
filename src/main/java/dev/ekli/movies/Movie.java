package dev.ekli.movies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

/*
    There are two collections, Movie and Rating. Seperate classes for each. This is the Movie class with all the attributes.
*/

@Document (collection = "movies")   // Indicates all of the neccessary properties for this collection of movies.
@Data   // replaces getters and setters
@AllArgsConstructor // constructor with one paramater for every field in the class
@NoArgsConstructor
public class Movie {
    @Id // let application know that this id variable should be treated as the unique identifier in the database
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    @DocumentReference  // put reviews in a seperate collection on MongoDB
    private List<Review> reviewIds; // W/0 DocumentReference, Embedded relationship all related reviews to movie will be to this list.

    public Movie(String imdbId, String title, String releaseDate, String trailerLink, String poster, List<String> backdrops, List<String> genres) {
        this.imdbId = imdbId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
        this.poster = poster;
        this.backdrops = backdrops;
        this.genres = genres;
    }
}
