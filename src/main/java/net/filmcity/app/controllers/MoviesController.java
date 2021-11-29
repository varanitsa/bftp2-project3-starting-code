package net.filmcity.app.controllers;

import net.filmcity.app.domain.Movie;
import net.filmcity.app.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoviesController {

    private final MovieRepository movieRepository;

    @Autowired
    MoviesController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    @DeleteMapping("/movies/{id}")
    public Movie deleteMovieById(@PathVariable Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
        movieRepository.deleteById(id);
        return movie;
    }

    @PutMapping("/movies")
    public Movie updateMovieById(@RequestBody Movie movie) {
        movieRepository.findById(movie.getId()).orElseThrow(MovieNotFoundException::new);
        return movieRepository.save(movie);}
}
