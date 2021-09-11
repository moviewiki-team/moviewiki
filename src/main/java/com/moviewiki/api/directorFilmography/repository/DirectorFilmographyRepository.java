package com.moviewiki.api.directorFilmography.repository;

import com.moviewiki.api.director.domain.Director;
import com.moviewiki.api.directorFilmography.domain.DirectorFilmography;
import com.moviewiki.api.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DirectorFilmographyRepository extends JpaRepository<DirectorFilmography, Long> {

    public List<DirectorFilmography> findDirectorFilmographyByDirector(Director director);
    public List<DirectorFilmography> findDirectorFilmographyByMovie(Movie movie);
}
