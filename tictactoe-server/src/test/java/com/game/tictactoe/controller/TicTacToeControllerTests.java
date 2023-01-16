package com.game.tictactoe.controller;

import com.game.tictactoe.entity.Game;
import com.game.tictactoe.service.TicTacToeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    public void testCreateGame() throws Exception {
        Game game = new Game();
        game.setId(1L);
        Integer boardSize = 3;

        when(ticTacToeService.createNewGame(boardSize)).thenReturn(game);

        mockMvc.perform(post("/api/tictactoe/v1/game?size={boardSize}", boardSize))
                .andExpect(status().isCreated())
                .andExpect(content().json("{'id': 1}"));

        verify(ticTacToeService, times(1)).createNewGame(boardSize);
    }

}

