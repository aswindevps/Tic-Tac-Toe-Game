package com.game.tictactoe.service.impl;

import com.game.tictactoe.constant.TicTacToeConstant;
import com.game.tictactoe.entity.Board;
import com.game.tictactoe.service.BoardStrategy;
import org.springframework.stereotype.Component;

@Component
public class Board3By3Strategy implements BoardStrategy {

    public boolean checkWin(Board board, char currentPlayer) {
        // check for horizontal win
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getPositions()[i][0] == currentPlayer && board.getPositions()[i][1] == currentPlayer && board.getPositions()[i][2] == currentPlayer) {
                return true;
            }
        }

        // check for vertical win
        for (int j = 0; j < board.getSize(); j++) {
            if (board.getPositions()[0][j] == currentPlayer && board.getPositions()[1][j] == currentPlayer && board.getPositions()[2][j] == currentPlayer) {
                return true;
            }
        }

        // check for diagonal win
        if (board.getPositions()[0][0] == currentPlayer && board.getPositions()[1][1] == currentPlayer && board.getPositions()[2][2] == currentPlayer) {
            return true;
        }
        return board.getPositions()[0][2] == currentPlayer && board.getPositions()[1][1] == currentPlayer && board.getPositions()[2][0] == currentPlayer;
    }

    public boolean checkDraw(Board board) {
        boolean isDraw = true;

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getPositions()[i][j] == '\u0000') {
                    isDraw = false;
                    break;
                }
            }
        }
        return isDraw;
    }

}
