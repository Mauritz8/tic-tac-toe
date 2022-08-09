package com.company;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
    	Scanner scanner = new Scanner(System.in);

	    Game game = new Game();
	    Engine engine = new Engine();

	    Player player1 = new Player(0, "Mauritz", 'X');
        Player player2 = new Player(1, "Engine", 'O');
	    game.initialize(player1, player2);

		game.getBoard().print();
	    while (game.getResult().getGameStatus() == GameStatus.ACTIVE) {
	    	int row;
	    	int col;
			Player playerToMove = game.getPlayerToMove();
	    	if (playerToMove.getId() == game.getPlayers()[1].getId()) {
	    		int[] bestMove = engine.getBestMove(game);
	    		row = bestMove[0];
	    		col = bestMove[1];
				TimeUnit.SECONDS.sleep(2);
			} else {
				System.out.print("row: ");
				row = scanner.nextInt();
				System.out.print("col: ");
				col = scanner.nextInt();
			}

			game.setMark(playerToMove, row, col);
			game.getBoard().print();
		}

		System.out.println(game.getResult().getMessage());
    }
}
