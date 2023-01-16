package com.game.tictactoe.service.impl;

import com.game.tictactoe.entity.Game;
import com.game.tictactoe.repository.BoardRepository;
import com.game.tictactoe.repository.GameRepository;
import com.game.tictactoe.repository.PlayerRepository;
import com.game.tictactoe.service.TicTacToeService;
import org.springframework.stereotype.Service;

@Service
public class TicTacToeServiceImpl implements TicTacToeService {

    private final GameRepository gameRepository;
    private final BoardRepository boardRepository;
    private final PlayerRepository playerRepository;

    public TicTacToeServiceImpl(GameRepository gameRepository, BoardRepository boardRepository, PlayerRepository playerRepository) {
        this.gameRepository = gameRepository;
        this.boardRepository = boardRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public Game createNewGame(Integer size) {
        return null;
    }
}
