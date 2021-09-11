package com.moviewiki.api.genre.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private @Column(name = "genre_id") String genreId;

    private @Column(name = "genre_name") String genreName;
}
