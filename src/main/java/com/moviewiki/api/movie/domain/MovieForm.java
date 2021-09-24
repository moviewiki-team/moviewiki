package com.moviewiki.api.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieForm {

    private String movieName;
    private String movieOgName;
    private List<Long> directorId;
    private List<Long> actorId;
    private List<String> nationId;
    private String movieProfile;
    private String runningTime;
    private String releaseDate;
    private String filmRating;
    private List<String> genreId;
    private String summary;
    private double avgRating;


    // 검색 TEST
    public Movie toEntity(){
        Movie movie = Movie.builder()
                .movieName(movieName)
                .movieOgName(movieOgName)
                .movieProfile(movieProfile)
                .filmRating(filmRating)
                .avgRating(avgRating)
                .build();
        return movie;
    }

    @Builder
    public MovieForm(String movieName, String movieOgName, String movieProfile, String filmRating, double avgRating) {
        this.movieName = movieName;
        this.movieOgName = movieOgName;
        this.movieProfile = movieProfile;
        this.filmRating = filmRating;
        this.avgRating = avgRating;
    }
}