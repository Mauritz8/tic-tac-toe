package com.company;

public class Result {

    private GameStatus gameStatus = GameStatus.ACTIVE;
    private String message;

    public Result() {}

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
