package com.game.tictactoe.service;

public interface BoardStrategy {

    public boolean checkWin(char[][] board, char currentPlayer);

    public boolean checkDraw(char[][] board);
}
