package com.game.tictactoe.service;

import com.game.tictactoe.entity.Game;
import com.game.tictactoe.entity.Move;
import com.game.tictactoe.exception.TicTacToeException;

public interface TicTacToeService {
    Game createNewGame(Integer size);
    Game getGame(Long id);
    Game makeMove(Long id, Move move);
}