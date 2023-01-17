package com.game.tictactoe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.validation.constraints.NotNull;

@Entity
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    @NotNull
    private Integer size;

    @Getter
    @Setter
    @NotNull
    @ElementCollection
    @OrderColumn
    private char[][] positions;

    public Board() {}

    public Board(int size) {
        this.size = size;
        this.positions = new char[size][size];
    }
}
