package com.game.tictactoe.service;

import com.game.tictactoe.entity.Board;

public interface BoardStrategy {

    public boolean checkWin(Board board, char currentPlayer);

    public boolean checkDraw(Board board);
}
