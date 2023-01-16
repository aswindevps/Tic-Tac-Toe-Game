package com.game.tictactoe.service;

import com.game.tictactoe.constant.TicTacToeConstant;
import com.game.tictactoe.entity.Board;
import com.game.tictactoe.entity.Game;
import com.game.tictactoe.entity.Player;
import com.game.tictactoe.repository.BoardRepository;
import com.game.tictactoe.repository.GameRepository;
import com.game.tictactoe.repository.PlayerRepository;
import com.game.tictactoe.service.impl.TicTacToeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicTacToeServiceTests {
    @Mock
    private GameRepository gameRepository;

    @Mock
    private BoardRepository boardRepository;

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private TicTacToeServiceImpl ticTacToeService;

    @BeforeEach
    public void setUp() {
        ticTacToeService = new TicTacToeServiceImpl(gameRepository, boardRepository, playerRepository);
    }

    @Test
    public void testCreateNewGame() {
        Game game = new Game();
        Board board = new Board(3);

        // Player 1
        Player player1 = new Player();
        player1.setName("Player 1");
        player1.setSymbol(TicTacToeConstant.PLAYER_1);
        // Player 2
        Player player2 = new Player();
        player2.setName("Player 2");
        player2.setSymbol(TicTacToeConstant.PLAYER_2);

        List<Player> players = List.of(player1, player2);

        game.setBoard(board);
        game.setCurrentPlayer(player1);
        game.setPlayers(players);
        game.setStatus(TicTacToeConstant.GAME_IN_PROGRESS);

        when(boardRepository.save(any(Board.class))).thenReturn(board);
        when(playerRepository.save(any(Player.class))).thenReturn(player1);
        when(playerRepository.save(any(Player.class))).thenReturn(player2);
        when(gameRepository.save(any(Game.class))).thenReturn(game);

        Game newGame = ticTacToeService.createNewGame(board.getSize());

        assertArrayEquals(new char[][] {
                {'\u0000', '\u0000', '\u0000'},
                {'\u0000', '\u0000', '\u0000'},
                {'\u0000', '\u0000', '\u0000'}
        }, newGame.getBoard().getPositions());
        assertEquals(TicTacToeConstant.PLAYER_1, newGame.getCurrentPlayer().getSymbol());
        assertEquals(TicTacToeConstant.GAME_IN_PROGRESS, newGame.getStatus());
        verify(gameRepository, times(1)).save(any(Game.class));
    }

}
