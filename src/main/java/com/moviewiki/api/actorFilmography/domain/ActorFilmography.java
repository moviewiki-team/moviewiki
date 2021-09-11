package com.moviewiki.api.actorFilmography.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ACTOR_FILMOGRAPHY")
public class ActorFilmography implements Serializable {
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Long id;

		@ManyToOne(targetEntity = Actor.class)
		@JoinColumn(name = "ACTOR_ID")
		private Actor actor;

		@ManyToOne(targetEntity = Movie.class)
		@JoinColumn(name = "MOVIE_ID")
		private Movie movie;
		
		@Column(name = "ROLE")
		private String role;
		
		@Column(name = "CHARACTERS")
		private String characters;
		
}
