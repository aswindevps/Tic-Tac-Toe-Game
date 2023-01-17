# Tic-Tac-Toe

TicTacToe is a classic game played by two players, X and O, on a 3x3 grid. The objective of the game is to place three of your symbols (X or O) in a row, either horizontally, vertically, or diagonally. The player who successfully completes this first, wins the game.

In this online version of TicTacToe, players have the option to play a multiplayer game. The game board is displayed on the screen and players can place their symbols by clicking on the desired square.

Overall, TicTacToe is a fun and easy-to-play game that can be enjoyed by players of all ages. Whether you're looking for a quick game during your lunch break or a friendly competition with friends and family, TicTacToe is the perfect choice.

## Pre-requisites

### Tic-Tac-Toe Server

- Java 17
- Maven

### Tic-Tac-Toe UI

- Node 16
- NPM/YARN

## Clone Project

- `git clone git@github.com:aswindevps/MjAyMy1ERVYxLTAwMi9UaWNUYWNUb2U-.git`
- `cd MjAyMy1ERVYxLTAwMi9UaWNUYWNUb2U-`

## Build & Run

### Tic-Tac-Toe Server

- `cd tictactoe-server`
- `mvn clean install`
- `cd target`
- `java -jar tictactoe-0.0.1-SNAPSHOT.jar`

  > Runs Tic-Tac-Toe server.
  > Open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) to view API documentation.

### Tic-Tac-Toe UI

- `cd tictactoe-ui`
- `npm install` or `yarn`
- `npm start` or `yarn start`

  > Runs Tic-Tac-Toe UI.
  > Open [http://localhost:3000](http://localhost:3000) to view game in your browser.
