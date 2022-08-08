package com.company;

public class Board {
    char[][] squares = new char[3][3];

    public Board() {
        reset();
    }

    public void reset() {
        for (int row = 0; row<squares.length; row++) {
            for (int col = 0; col<squares[0].length; col++) {
                squares[row][col] = ' ';
            }
        }
    }

    public boolean isDraw() {
        for (int row = 0; row < squares.length; row++) {
            for (int col = 0; col < squares[0].length; col++) {
                if (squares[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // x and y are the coordinates for the last move made by player
    public boolean playerWon(Player player, int x, int y) {
        int col, row, diag, rdiag;
        col = row = diag = rdiag = 0;
        int n = squares.length;
        for (int i = 0; i<n; i++) {
            if (squares[x][i] == player.getMark()) {
                col++;
            }
            if (squares[i][y] == player.getMark()) {
                row++;
            }
            if (squares[i][i] == player.getMark()) {
                diag++;
            }
            if (squares[i][n-i-1] == player.getMark()) {
                rdiag++;
            }
        }
        if (col == n || row == n || diag == n || rdiag == n) {
            return true;
        }
        return false;
    }

    public void print() {
        System.out.println("    1   2   3");
        System.out.println("  ┌───┬───┬───┐");
        System.out.println("A │ "
                + squares[0][0] + " │ "
                + squares[0][1] + " │ "
                + squares[0][2] + " │ ");
        System.out.println("  ├───┼───┼───┤");
        System.out.println("B │ "
                + squares[1][0] + " │ "
                + squares[1][1] + " │ "
                + squares[1][2] + " │ ");
        System.out.println("  ├───┼───┼───┤");
        System.out.println("C │ "
                + squares[2][0] + " │ "
                + squares[2][1] + " │ "
                + squares[2][2] + " │ ");
        System.out.println("  └───┴───┴───┘");
    }
}
