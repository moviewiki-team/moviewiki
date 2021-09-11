package com.moviewiki.api.actorFilmography.service;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.actorFilmography.domain.ActorFilmography;
import com.moviewiki.api.actorFilmography.repository.ActorFilmographyRepository;
import com.moviewiki.api.movie.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorFilmographyServiceImpl implements ActorFilmographyService {

    @Autowired
    private ActorFilmographyRepository actorFilmographyRepository;

    @Override
    public List<ActorFilmography> findActorFilmographyByActor(Actor actor) {
        return actorFilmographyRepository.findActorFilmographyByActor(actor);
    }

    @Override
    public List<ActorFilmography> findActorFilmographyByMovie(Movie movie) {
        return  actorFilmographyRepository.findActorFilmographyByMovie(movie);
    }
}
