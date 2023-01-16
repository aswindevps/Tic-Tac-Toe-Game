package com.game.tictactoe.exception;

import com.game.tictactoe.util.TicTacToeStatusType;
import lombok.Data;

@Data
public class TicTacToeException extends Exception {

    private String code;
    private String message;
    private TicTacToeStatusType type;

    public TicTacToeException(String code, String message, TicTacToeStatusType type) {
        this.code = code;
        this.message = message;
        this.type = type;
    }
}
