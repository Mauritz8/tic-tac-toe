package com.company;

public class Engine {

    private final int MAX_DEPTH = 15;

    public int miniMax(Game game, int depth, boolean isMaximizing) {

        Board board = game.getBoard();
        Player[] players = game.getPlayers();
        int boardVal = evaluateGame(game);

        if (Math.abs(boardVal) == 10 || board.isDraw() || depth == 0) {
            return boardVal;
        }

        if (isMaximizing) {
            int highestVal = Integer.MIN_VALUE;
            for (int row = 0; row < board.getWidth(); row++) {
                for (int col = 0; col < board.getWidth(); col++) {
                    if (board.squareIsEmpty(row, col)) {
                        board.setMark(row, col, players[1].getMark());
                        highestVal = Math.max(highestVal, miniMax(game, depth - 1, false));
                        board.setMark(row, col, ' ');
                    }
                }
            }
            return highestVal;
        } else {
            int lowestVal = Integer.MAX_VALUE;
            for (int row = 0; row < board.getWidth(); row++) {
                for (int col = 0; col < board.getWidth(); col++) {
                    if (board.squareIsEmpty(row, col)) {
                        board.setMark(row, col, players[0].getMark());
                        lowestVal = Math.min(lowestVal, miniMax(game, depth - 1, true));
                        board.setMark(row, col, ' ');
                    }
                }
            }
            return lowestVal;
        }
    }

    public int[] getBestMove(Game game) {
        Board board = game.getBoard();
        Player[] players = game.getPlayers();
        int[] bestMove = {-1, -1};
        int bestValue = Integer.MIN_VALUE;


        for (int row = 0; row < board.getWidth(); row++) {
            for (int col = 0; col < board.getWidth(); col++) {
                if (board.squareIsEmpty(row, col)) {
                    board.setMark(row, col, players[1].getMark());
                    int moveValue = miniMax(game, MAX_DEPTH, false);
                    board.setMark(row, col, ' ');
                    if (moveValue > bestValue) {
                        bestMove[0] = row;
                        bestMove[1] = col;
                        bestValue = moveValue;
                    }
                }
            }
        }
        return bestMove;
    }

    private int evaluateGame(Game game) {
        Board board = game.getBoard();
        Player[] players = game.getPlayers();
        int rowSum = 0;
        int bWidth = board.getWidth();
        int player1Win = players[0].getMark() * bWidth;
        int player2Win = players[1].getMark() * bWidth;

        // Check rows for winner.
        for (int row = 0; row < bWidth; row++) {
            for (int col = 0; col < bWidth; col++) {
                rowSum += board.getSquare(row, col);
            }
            if (rowSum == player1Win) {
                return -10;
            } else if (rowSum == player2Win) {
                return 10;
            }
            rowSum = 0;
        }

        // Check columns for winner.
        rowSum = 0;
        for (int col = 0; col < bWidth; col++) {
            for (int row = 0; row < bWidth; row++) {
                rowSum += board.getSquare(row, col);
            }
            if (rowSum == player1Win) {
                return -10;
            } else if (rowSum == player2Win) {
                return 10;
            }
            rowSum = 0;
        }

        // Check diagonals for winner.
        // Top-left to bottom-right diagonal.
        rowSum = 0;
        for (int i = 0; i < bWidth; i++) {
            rowSum += board.getSquare(i, i);
        }
        if (rowSum == player1Win) {
            return -10;
        } else if (rowSum == player2Win) {
            return 10;
        }

        // Top-right to bottom-left diagonal.
        rowSum = 0;
        int indexMax = bWidth - 1;
        for (int i = 0; i <= indexMax; i++) {
            rowSum += board.getSquare(i, indexMax - i);
        }
        if (rowSum == player1Win) {
            return -10;
        } else if (rowSum == player2Win) {
            return 10;
        }

        return 0;
    }
}
