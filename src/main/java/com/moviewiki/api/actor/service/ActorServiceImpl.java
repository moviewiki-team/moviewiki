package com.moviewiki.api.actor.service;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.actor.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public void save(Actor actor) {
        actorRepository.save(actor);
    }

    @Override
    public Optional<Actor> findById(Long actorId) {
        return actorRepository.findById(actorId);
    }

    @Override
    public List<Actor> findByActorName(String actorName) {
        return actorRepository.findByActorName(actorName);
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }
}