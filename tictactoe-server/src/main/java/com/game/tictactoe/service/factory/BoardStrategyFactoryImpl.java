package com.game.tictactoe.service.factory;

import com.game.tictactoe.exception.TicTacToeException;
import com.game.tictactoe.service.BoardStrategy;
import com.game.tictactoe.service.impl.Board3By3Strategy;
import com.game.tictactoe.util.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class BoardStrategyFactoryImpl implements BoardStrategyFactory {

    @Override
    public BoardStrategy getStrategy(Integer size) throws TicTacToeException {
        if(size == 3) {
            return new Board3By3Strategy();
        }else{
            throw new TicTacToeException(ErrorCode.INVALID_GAME_BOARD_SIZE.getCode(), ErrorCode.INVALID_GAME_BOARD_SIZE.getMessage(), ErrorCode.INVALID_GAME_BOARD_SIZE.getType());
        }
    }
}
