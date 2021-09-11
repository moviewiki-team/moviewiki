package com.moviewiki.api.actorFilmography.service;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.actorFilmography.domain.ActorFilmography;
import com.moviewiki.api.movie.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActorFilmographyService {

    public List<ActorFilmography> findActorFilmographyByActor(Actor actor);
    public List<ActorFilmography> findActorFilmographyByMovie(Movie movie);
}
