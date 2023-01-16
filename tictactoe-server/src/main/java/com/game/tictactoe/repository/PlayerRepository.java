package com.game.tictactoe.repository;

import com.game.tictactoe.entity.Player;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends BaseRepository<Player, Long> { }
