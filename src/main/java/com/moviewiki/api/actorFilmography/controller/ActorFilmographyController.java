package com.moviewiki.api.actorFilmography.controller;

import com.moviewiki.api.actorFilmography.domain.ActorFilmography;
import com.moviewiki.api.actorFilmography.service.ActorFilmographyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ActorFilmographyController {

    @Autowired
    private ActorFilmographyServiceImpl actorFilmographyServiceImpl;

    @GetMapping("/actorfilmography/read/actor")
    public String readActor(){
        return "readActor";
    }

    @PostMapping("/actorfilmography/actor")
    public String readActorId(ActorFilmography actorFilmography, Model model) {
        List<ActorFilmography> actorList2 = actorFilmographyServiceImpl.findActorFilmographyByActor(actorFilmography.getActor());
        model.addAttribute("actors2",actorList2);
        return "readActor";
    }

    @GetMapping("/actorfilmography/read/movie")
    public String readMovie() {
        return "readMovie";
    }

    @PostMapping("/actorfilmography/movie")
    public String readMovieId(ActorFilmography actorFilmography, Model model) {
        List<ActorFilmography> movieList2 = actorFilmographyServiceImpl.findActorFilmographyByMovie(actorFilmography.getMovie());
        model.addAttribute("movie2",movieList2);
        return "readMovie";
    }



//    @GetMapping("/api/movie/{movieId}")
//    public ActorFilmographyRepository readMovie (@PathVariable("movieId") String movieId){
//        if(MovieRepository.findMovieById(movieId).isPresent()){
//            ActorFilmography actorFilmography = MovieRepository.findMovieById(movieId).get();
//            return ActorFilmography;
//        }
//        return null;
    }


