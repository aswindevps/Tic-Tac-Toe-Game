package com.game.tictactoe.util;

import lombok.Getter;

@Getter
public enum ErrorCode {

    GAME_NOT_FOUND("T-100", "Game not found", TicTacToeStatusType.ENTITY_NOT_FOUND),
    PLAYER_NOT_FOUND("T-101", "Player not found", TicTacToeStatusType.ENTITY_NOT_FOUND),
    INVALID_GAME_BOARD_SIZE("T-102", "Invalid game board size", TicTacToeStatusType.INVALID_ENTITY);

    private final String code;
    private final String message;
    private final TicTacToeStatusType type;

    ErrorCode(String code, String message, TicTacToeStatusType type) {
        this.code = code;
        this.message = message;
        this.type = type;
    }
}

