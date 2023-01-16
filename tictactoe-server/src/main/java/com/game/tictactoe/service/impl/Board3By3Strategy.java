package com.game.tictactoe.service.impl;

import com.game.tictactoe.service.BoardStrategy;
import org.springframework.stereotype.Component;

@Component
public class Board3By3Strategy implements BoardStrategy {

    public boolean checkWin(char[][] board, char currentPlayer) {
        return false;
    }

    public boolean checkDraw(char[][] board) {
        return false;
    }

}
