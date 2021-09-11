package com.moviewiki.api.directorFilmography.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.moviewiki.api.director.domain.Director;
import com.moviewiki.api.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DIRECTOR_FILMOGRAPHY")
public class DirectorFilmography implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(targetEntity = Director.class)
	@JoinColumn(name = "DIRECTOR_ID")
	private Director director;
	

	@ManyToOne(targetEntity = Movie.class)
	@JoinColumn(name = "MOVIE_ID")
	private Movie movie;
}
