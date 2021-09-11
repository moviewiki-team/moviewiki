package com.moviewiki.api.nation.domain;

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
@Table(name="nations")
public class Nation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private @Column(name = "nation_id") String nationId;

    private @Column(name = "nation_name") String nationName;
}