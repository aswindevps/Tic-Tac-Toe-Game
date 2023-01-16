package com.game.tictactoe.service.factory;

import com.game.tictactoe.exception.TicTacToeException;
import com.game.tictactoe.service.BoardStrategy;

public interface BoardStrategyFactory {
    BoardStrategy getStrategy(Integer size);
}
