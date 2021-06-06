package tictactoe;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * A player in a game of tic tac toe.
 */
public class Player {
	/**
	 * All the positions which this player holds
	 */
	private ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	/**
	 * The name of this player
	 */
	private String name;

	/**
	 * Constructs a new Player object.
	 * @param playerName the name of this player
	 */
	public Player(String playerName) {
		name = playerName;
	}

	/**
	 * Getter for all player positions.
	 * @return The list of all player positions
	 */
	public ArrayList<Integer> getMoveHistory() {
		return playerPositions;
	}

	/**
	 * Generates a new position for a computer player.
	 * @param comPos The old computer position
	 * @return The new computer position
	 */
	public int generateComPosition(int comPos) {
		Random r = new Random();
		comPos = r.nextInt(9) + 1;
		return comPos;
	}

	/**
	 * Allows the player to make their move and processes it.
	 * @param gameBoard The tic tac toe board
	 * @param pos The position that is claimed by this player
	 * @param player The name of the player making the move
	 */
	public void makeMove(char[][] gameBoard, int pos, String player) {
		char symbol = ' ';
		
		if(player.equals("user")) {
			symbol = 'X';
		}
		else if(player.equals("computer")) {
			symbol = 'O';
		}
		
		if(pos == 1) {
			gameBoard[0][0] = symbol;
			playerPositions.add(1);
		}
		else if(pos == 2) {
			gameBoard[0][2] = symbol;
			playerPositions.add(2);
		}
		else if(pos == 3) {
			gameBoard[0][4] = symbol;
			playerPositions.add(3);
		}
		else if(pos == 4) {
			gameBoard[2][0] = symbol;
			playerPositions.add(4);
		}
		else if(pos == 5) {
			gameBoard[2][2] = symbol;
			playerPositions.add(5);
		}
		else if(pos == 6) {
			gameBoard[2][4] = symbol;
			playerPositions.add(6);
		}
		else if(pos == 7) {
			gameBoard[4][0] = symbol;
			playerPositions.add(7);
		}
		else if(pos == 8) {
			gameBoard[4][2] = symbol;
			playerPositions.add(8);
		}
		else if(pos == 9) {
			gameBoard[4][4] = symbol;
			playerPositions.add(9);
		}
		else {
			JOP.msg("Invalid position. Please try again.");
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your placement (1-9): ");
			pos = scan.nextInt();
			makeMove(gameBoard, pos, player);
		}
	}
}
