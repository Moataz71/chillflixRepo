package com.molveno.molveno.chillflix.movie;

import com.molveno.molveno.chillflix.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "/get-allmovies", method = RequestMethod.GET)
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @RequestMapping(value = "/get-movie", method = RequestMethod.GET)
    public Movie getAll(@RequestBody Movie movie) {
        return movieRepository.findById(movie.getId());
    }

    @RequestMapping(value = "/delete-movie", method = RequestMethod.DELETE)
    public void deleteMovie(@RequestBody Movie movie) {
        movieRepository.deleteById(movie.getId());
    }

    @RequestMapping(value = "/add-movie", method = RequestMethod.POST, consumes = "application/json")
    public long addMovie(@RequestBody Movie movie) {
        Movie newMovie = movieRepository.save(movie);
        return newMovie.getId();
    }
}
