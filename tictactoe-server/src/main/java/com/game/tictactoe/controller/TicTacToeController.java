package com.game.tictactoe.controller;

import com.game.tictactoe.entity.Game;
import com.game.tictactoe.entity.Move;
import com.game.tictactoe.exception.TicTacToeException;
import com.game.tictactoe.service.TicTacToeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * Retrieve an existing game
     *
     * This endpoint handles the retrieval of existing Tic-Tac-Toe games on the server. It takes in a single path variable called "id", which is used to identify the game.
     * The method uses the ticTacToeService.getGame(id) to retrieve the specified game and returns a fully initialized Game object including the unique game ID and current game state.
     * The endpoint produces a response in JSON format.
     *
     * @param id - the unique id of the game
     * @return - a fully initialized Game object including the unique game ID and current game state
     * @throws TicTacToeException - if there is any error while retrieving the game
     */
    @GetMapping("/game/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Long id) throws TicTacToeException {
        return new ResponseEntity<>(ticTacToeService.getGame(id), HttpStatus.OK);
    }

    /**
     * Make a move
     *
     * This endpoint handles the making of moves in a Tic-Tac-Toe game. It takes in a single request parameter called "id", which is used to specify the unique game ID of the game in which the move is to be made.
     * The method uses the ticTacToeService.makeMove(id, move) to make a move in the game and returns a fully initialized Game object including the unique game ID and current game state.
     * The endpoint produces a response in JSON format.
     *
     * @param gameId - the unique game ID of the game in which the move is to be made
     * @param move - the move to be made
     * @return - a fully initialized Game object including the unique game ID and current game state
     * @throws TicTacToeException - if there is any error while making the move
     */
    @PutMapping(path = "/game/{gameId}/move", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Game> makeMove(@PathVariable Long gameId, @RequestBody Move move) throws TicTacToeException {
        Game game = ticTacToeService.makeMove(gameId, move);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

}
