package com.game.tictactoe.service.impl;

import com.game.tictactoe.constant.TicTacToeConstant;
import com.game.tictactoe.entity.Board;
import com.game.tictactoe.entity.Game;
import com.game.tictactoe.entity.Move;
import com.game.tictactoe.entity.Player;
import com.game.tictactoe.exception.TicTacToeException;
import com.game.tictactoe.repository.BoardRepository;
import com.game.tictactoe.repository.GameRepository;
import com.game.tictactoe.repository.PlayerRepository;
import com.game.tictactoe.service.BoardStrategy;
import com.game.tictactoe.service.TicTacToeService;
import com.game.tictactoe.service.factory.BoardStrategyFactory;
import com.game.tictactoe.util.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicTacToeServiceImpl implements TicTacToeService {

    private final BoardStrategyFactory boardStrategyFactory;
    private final GameRepository gameRepository;
    private final BoardRepository boardRepository;
    private final PlayerRepository playerRepository;

    public TicTacToeServiceImpl(GameRepository gameRepository, BoardRepository boardRepository, PlayerRepository playerRepository, BoardStrategyFactory boardStrategyFactory) {
        this.gameRepository = gameRepository;
        this.boardRepository = boardRepository;
        this.playerRepository = playerRepository;
        this.boardStrategyFactory = boardStrategyFactory;
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
        player1.setColor("#b81515");
        player1 = playerRepository.save(player1);

        Player player2 = new Player();
        player2.setName("Player 2");
        player2.setSymbol(TicTacToeConstant.PLAYER_2);
        player2.setColor("#6161e3");
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
    public Game getGame(Long id) throws TicTacToeException {
        return gameRepository.findById(id).orElseThrow(() ->  new TicTacToeException(ErrorCode.GAME_NOT_FOUND.getCode(), ErrorCode.GAME_NOT_FOUND.getMessage(), ErrorCode.GAME_NOT_FOUND.getType()));
    }

    @Override
    public Game makeMove(Long id, Move move) throws TicTacToeException {
        Game game = getGame(id);

        BoardStrategy boardStrategy = boardStrategyFactory.getStrategy(game.getBoard().getSize());

        Board board = game.getBoard();
        board.getPositions()[move.getRow()][move.getColumn()] = game.getCurrentPlayer().getSymbol();
        game.setBoard(board);

        game.setWinner(null);
        game.setStatus(TicTacToeConstant.GAME_IN_PROGRESS);

        if (boardStrategy.checkWin(board, game.getCurrentPlayer().getSymbol())) {
            game.setStatus(TicTacToeConstant.GAME_WON);
            game.setWinner(game.getCurrentPlayer());
            game.setCurrentPlayer(null);
        } else if (boardStrategy.checkDraw(board)) {
            game.setStatus(TicTacToeConstant.GAME_DRAW);
            game.setCurrentPlayer(null);
        } else {
            Player player1 = game.getPlayers().get(0);
            Player player2 = game.getPlayers().get(1);
            game.setCurrentPlayer(game.getCurrentPlayer().getSymbol() == TicTacToeConstant.PLAYER_1 ? player2 : player1);
        }

        return gameRepository.save(game);
    }
}
