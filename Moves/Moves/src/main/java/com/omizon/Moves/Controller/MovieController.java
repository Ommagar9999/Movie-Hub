package com.omizon.Moves.Controller;

import com.omizon.Moves.entity.Movie;
import com.omizon.Moves.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Get All Movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Get Movie By Id
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    // Add Movie
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    // Search Movie
    @GetMapping("/search")
    public List<Movie> searchMovie(@RequestParam String name) {
        return movieService.searchByName(name);
    }

    // Delete Movie
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Long id) {

        movieService.deleteMovie(id);

        return "Movie Deleted";
    }

}