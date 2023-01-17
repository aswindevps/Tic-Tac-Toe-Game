import React, { useState } from "react";
import { fetchGame, updateGame } from "../service/TicTacToeService";
import "./TicTacToe.scss";

function TicTacToe() {
  const [game, setGame] = useState(null);
  const [board, setBoard] = useState([]);

  const startGame = () => {
    fetchGame().then((response) => {
      setGame(response);
      setBoard(Array(response.board.size).fill(""));
    });
  };

  const makeMove = (row, column) => {
    const {
      winner,
      board: { positions },
      players,
    } = game;

    const playerSymbols = players.map((player) => player.symbol);
    if (winner != null || playerSymbols.includes(positions[row][column])) {
      return;
    }
    updateGame(game.id, { row, column }).then((response) => {
      setGame(response);
    });
  };

  const renderSquare = (row, column) => {
    const {
      board: { positions },
    } = game;
    return (
      <button className="GameCell" onClick={() => makeMove(row, column)}>
        {positions[row][column] === "X" && (
          <span style={{ color: "#b81515", fontWeight: 600 }}>
            {positions[row][column]}
          </span>
        )}
        {positions[row][column] === "O" && (
          <span style={{ color: "#6161e3", fontWeight: 600 }}>
            {positions[row][column]}
          </span>
        )}
      </button>
    );
  };

  return (
    <>
      <div className="App">
        <h1 className="AppHeader">Tic Tac Toe</h1>
        <hr />
        {game && (
          <div className="PlayerContainer">
            {game.players.map((player, index) => {
              return (
                <div className="Player" key={player.symbol}>
                  <span>{player.name} : </span>{" "}
                  <span style={{ color: player.color }}>{player.symbol}</span>
                </div>
              );
            })}
          </div>
        )}
        <button
          className="StartButton"
          onClick={() => startGame()}
          disabled={game && game.currentPlayer != null && game.winner == null}
        >
          Start Game
        </button>
        <div>
          {game && (
            <table>
              <tbody>
                {board &&
                  board.map((row, rowIndex) => {
                    return (
                      <tr key={rowIndex}>
                        {board.map((column, columnIndex) => {
                          return (
                            <td key={columnIndex}>
                              {renderSquare(rowIndex, columnIndex)}
                            </td>
                          );
                        })}
                      </tr>
                    );
                  })}
              </tbody>
            </table>
          )}
        </div>
        <div className="GameStatus">
          <span>{game && game.status}</span>
          <span>{game && game.winner && ` - ${game.winner.name}`}</span>
        </div>
      </div>
    </>
  );
}

export default TicTacToe;
