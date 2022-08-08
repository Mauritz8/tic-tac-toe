package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

	    Game game = new Game();

	    Player player1 = new Player(0, "Mauritz", 'X');
        Player player2 = new Player(1, "Marika", 'O');
	    game.initialize(player1, player2);

		game.getBoard().print();
	    while (game.getResult().getGameStatus() == GameStatus.ACTIVE) {
			System.out.print("row: ");
			int row = scanner.nextInt();
			System.out.print("col: ");
			int col = scanner.nextInt();
			Player playerToMove = game.getPlayerToMove();

			game.setMark(playerToMove, row, col);
			game.getBoard().print();
		}

		System.out.println(game.getResult().getMessage());
    }
}
