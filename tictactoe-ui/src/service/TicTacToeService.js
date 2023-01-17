import { apiCall } from "../helper/APIHelper";

function fetchGame() {
  return apiCall("game?size=3", "post");
}

function updateGame(gameId, move) {
  return apiCall(`game/${gameId}/move`, "put", move);
}
export { fetchGame, updateGame };
