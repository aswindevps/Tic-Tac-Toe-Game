package com.game.tictactoe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Game {

    @Getter
    @Setter
    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    @OneToOne
    @NotNull
    private Board board;

    @Getter
    @Setter
    @OneToOne
    private Player currentPlayer;

    @Getter
    @Setter
    @NotNull
    private String status;

    @Getter
    @Setter
    @OneToOne
    private Player winner;

    @Getter
    @Setter
    @OneToMany
    private List<Player> players;

}