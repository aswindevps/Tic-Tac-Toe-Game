package com.game.tictactoe.repository;

import com.game.tictactoe.entity.Game;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends BaseRepository<Game, Long> { }
