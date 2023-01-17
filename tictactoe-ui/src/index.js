import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import TicTacToe from "./app/TicTacToe";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <TicTacToe />
  </React.StrictMode>
);
