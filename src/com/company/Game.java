package com.company;

import java.util.Random;

public class Game {
    private Player[] players = new Player[2];
    private Player playerToMove;
    private Board board;
    private Result result;

    public void initialize(Player player1, Player player2) {
        players[0] = player1;
        players[1] = player2;

        playerToMove = getRandomPlayer();

        board = new Board();
        result = new Result();
    }

    public void newGame() {
        board.reset();
    }

    public void setMark(Player playerToMove, int row, int col) {
        if (playerToMove.getId() == players[0].getId()) {
            board.setMark(row, col, players[0].getMark());
            setPlayerToMove(players[1]);
        } else {
            board.setMark(row, col, players[1].getMark());
            setPlayerToMove(players[0]);
        }
        if (board.playerWon(playerToMove, row, col)) {
            result.setGameStatus(GameStatus.WIN);
            result.setMessage(playerToMove.getName() + " won!");
            return;
        }

        if (board.isDraw()) {
            result.setGameStatus(GameStatus.DRAW);
            result.setMessage("It's a draw");
            return;
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getPlayerToMove() {
        return playerToMove;
    }

    public void setPlayerToMove(Player playerToMove) {
        this.playerToMove = playerToMove;
    }

    public Board getBoard() {
        return board;
    }

    public Result getResult() {
        return result;
    }

    private Player getRandomPlayer() {
        Random random = new Random();
        int index = random.nextInt(players.length);
        return players[index];
    }
}
