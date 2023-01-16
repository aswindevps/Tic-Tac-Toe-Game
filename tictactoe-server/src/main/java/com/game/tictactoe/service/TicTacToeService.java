package com.game.tictactoe.service;

import com.game.tictactoe.entity.Game;

public interface TicTacToeService {
    Game createNewGame(Integer size);
}