package com.game.tictactoe.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class TicTacToeError {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String code;
    private String path;

    private TicTacToeError() {
        timestamp = LocalDateTime.now();
    }

    public TicTacToeError(HttpStatus status) {
        this();
        this.status = status;
    }

    public TicTacToeError(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
    }

    public TicTacToeError(HttpStatus status, String message, String code) {
        this();
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
