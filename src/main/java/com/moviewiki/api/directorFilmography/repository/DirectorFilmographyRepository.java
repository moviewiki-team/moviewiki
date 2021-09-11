package com.moviewiki.api.directorFilmography.repository;

import com.moviewiki.api.director.domain.Director;
import com.moviewiki.api.directorFilmography.domain.DirectorFilmography;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorFilmographyRepository extends JpaRepository<DirectorFilmography, Director> {
    public List<DirectorFilmography> findDirectorFilmographyByDirector(Director director);
}
