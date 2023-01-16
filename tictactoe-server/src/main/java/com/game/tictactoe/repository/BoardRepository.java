package com.game.tictactoe.repository;

import com.game.tictactoe.entity.Board;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends BaseRepository<Board, Long> { }
