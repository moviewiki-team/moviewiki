package com.moviewiki.api.movie.service;

import com.moviewiki.api.movie.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {

    public void save(Movie movie);

    public Optional<Movie> findById(Long movieId);

    public List<Movie> findAll();

//    public void deleteById(String movieId);
}
