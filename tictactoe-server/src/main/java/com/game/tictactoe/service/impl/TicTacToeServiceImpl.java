package com.game.tictactoe.service.impl;

import com.game.tictactoe.constant.TicTacToeConstant;
import com.game.tictactoe.entity.Board;
import com.game.tictactoe.entity.Game;
import com.game.tictactoe.entity.Move;
import com.game.tictactoe.entity.Player;
import com.game.tictactoe.repository.BoardRepository;
import com.game.tictactoe.repository.GameRepository;
import com.game.tictactoe.repository.PlayerRepository;
import com.game.tictactoe.service.TicTacToeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Board board = new Board(size);
        board = boardRepository.save(board);

        Game game = new Game();
        game.setBoard(board);

        Player player1 = new Player();
        player1.setName("Player 1");
        player1.setSymbol(TicTacToeConstant.PLAYER_1);
        player1 = playerRepository.save(player1);

        Player player2 = new Player();
        player2.setName("Player 2");
        player2.setSymbol(TicTacToeConstant.PLAYER_2);
        player2 = playerRepository.save(player2);

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        game.setPlayers(players);
        game.setCurrentPlayer(player1);
        game.setStatus(TicTacToeConstant.GAME_IN_PROGRESS);
        return gameRepository.save(game);
    }

    @Override
    public Game getGame(Long id) {
        return null;
    }

    @Override
    public Game makeMove(Long id, Move move) {
        return null;
    }
}
