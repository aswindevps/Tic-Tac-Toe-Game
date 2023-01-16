package com.game.tictactoe.controller;

import com.game.tictactoe.entity.Game;
import com.game.tictactoe.service.TicTacToeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/tictactoe/v1")
public class TicTacToeController {

    @Autowired
    TicTacToeService ticTacToeService;

    /**
     * Create a new game
     *
     * This endpoint handles the creation of new Tic-Tac-Toe games on the server. It takes in a single request parameter called "size", which is used to specify the size of the game board (e.g. a size of 3 creates a 3x3 game board).
     * The method uses the ticTacToeService.createNewGame(size) to create a new game and returns a fully initialized Game object including the unique game ID and current game state.
     * The endpoint produces a response in JSON format.
     *
     * @param size - the size of the game board
     * @return - a fully initialized Game object including the unique game ID and current game state
     */
    @PostMapping(path = "/game", produces = "application/json")
    public ResponseEntity<Game> createNewGame(@RequestParam Integer size) {
        Game game = ticTacToeService.createNewGame(size);
        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }

}
