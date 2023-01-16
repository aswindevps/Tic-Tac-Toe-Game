package com.game.tictactoe.controller;

import com.game.tictactoe.entity.Game;
import com.game.tictactoe.entity.Move;
import com.game.tictactoe.service.TicTacToeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TicTacToeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicTacToeService ticTacToeService;

    @Test
    public void testCreateNewGame() throws Exception {
        Game game = new Game();
        game.setId(1L);
        Integer boardSize = 3;

        when(ticTacToeService.createNewGame(boardSize)).thenReturn(game);

        mockMvc.perform(post("/api/tictactoe/v1/game?size={boardSize}", boardSize))
                .andExpect(status().isCreated())
                .andExpect(content().json("{'id': 1}"));

        verify(ticTacToeService, times(1)).createNewGame(boardSize);
    }

    @Test
    public void testGetGame() throws Exception {
        Long id = 1L;
        Game game = new Game();
        game.setId(id);
        when(ticTacToeService.getGame(id)).thenReturn(game);

        mockMvc.perform(get("/api/tictactoe/v1/game/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1}"));

        verify(ticTacToeService, times(1)).getGame(id);
    }

    @Test
    public void testMakeMove() throws Exception {
        Long id = 1L;
        Game game = new Game();
        game.setId(id);

        Move move = new Move();
        move.setRow(0);
        move.setColumn(0);

        when(ticTacToeService.makeMove(id, move)).thenReturn(game);

        mockMvc.perform(put("/api/tictactoe/v1/game/{id}/move", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"row\": 0, \"column\": 0}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1}"));

        verify(ticTacToeService, times(1)).makeMove(id, move);
    }

}

