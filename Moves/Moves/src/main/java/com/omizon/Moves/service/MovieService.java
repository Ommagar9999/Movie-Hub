package com.omizon.Moves.service;

import com.omizon.Moves.entity.Movie;
import com.omizon.Moves.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Get all movies
    public List<Movie> getAllMovies() {

        return movieRepository.findAll();
    }

    // Get movie by id
    public Movie getMovieById(Long id) {

        return movieRepository.findById(id)

                .orElseThrow(() ->
                        new RuntimeException("Movie Not Found"));
    }

    // Add movie
    public Movie addMovie(Movie movie) {

        if(movie.getName() == null ||
                movie.getName().isEmpty()) {

            throw new RuntimeException("Movie Name Required");
        }

        return movieRepository.save(movie);
    }

    // Search by name
    public List<Movie> searchByName(String name) {

        if(name == null || name.isEmpty()) {

            throw new RuntimeException("Enter Movie Name");
        }

        return movieRepository
                .findByNameContainingIgnoreCase(name);
    }

    // Delete movie
    public void deleteMovie(Long id) {

        if(!movieRepository.existsById(id)) {

            throw new RuntimeException("Movie Not Found");
        }

        movieRepository.deleteById(id);
    }

}