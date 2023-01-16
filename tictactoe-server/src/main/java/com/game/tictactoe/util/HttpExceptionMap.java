package com.game.tictactoe.util;

import org.springframework.http.HttpStatus;

import java.util.EnumMap;

public class HttpExceptionMap {
    private static final EnumMap<TicTacToeStatusType, HttpStatus> httpExceptionMap;

    private HttpExceptionMap() {
    }

    static {
        httpExceptionMap = new EnumMap<>(TicTacToeStatusType.class);
        httpExceptionMap.put(TicTacToeStatusType.ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        httpExceptionMap.put(TicTacToeStatusType.INVALID_ENTITY, HttpStatus.BAD_REQUEST);
    }

    public static HttpStatus getStatus(TicTacToeStatusType type) {
        return httpExceptionMap.get(type);
    }
}
