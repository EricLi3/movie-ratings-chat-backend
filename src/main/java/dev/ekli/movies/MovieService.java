package dev.ekli.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
* WHERE most of the logic will go for the API.
* Service class uses the Interface for the repo class, talks to the database and returns
* */
@Service
public class MovieService {
    // Database access methods
    @Autowired  // makes new instance of the class.
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }
    /*
    * May Return nothing, since findById may fail from Repositiory method.
    * Hence, Optional Return type*/
    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
