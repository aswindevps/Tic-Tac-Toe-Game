package com.game.tictactoe.service.factory;

import com.game.tictactoe.exception.TicTacToeException;
import com.game.tictactoe.service.BoardStrategy;
import org.springframework.stereotype.Component;

@Component
public class BoardStrategyFactoryImpl implements BoardStrategyFactory {

    @Override
    public BoardStrategy getStrategy(Integer size) {
        return null;
    }
}
