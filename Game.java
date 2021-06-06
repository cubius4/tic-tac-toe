package tictactoe;

import java.util.Random;
import java.util.Scanner;

/**
 * This class represents a game of tic tac toe, controlling the flow of the game
 */
public class Game {
	/**
	 * The amount of wins the user has
	 */
	private static int userWins;
	/**
	 * The amount of wins that the computer has
	 */
	private static int comWins;
	/**
	 * The amount of draws
	 */
	private static int draws;

	/**
	 * Starts a new game of tic tac toe, randomly selecting whether the player or computer goes first.
	 * @param gameBoard The tic tac toe board
	 * @param user The human player
	 * @param computer The computer player
	 */
	public static void startGame(char[][] gameBoard, Player user, Player computer) {
		Random R = new Random();
		int r = R.nextInt(2);
		if(r == 0) {
			game1(gameBoard, user, computer);
		}
		else {
			game2(gameBoard, user, computer);
		}
	}

	/**
	 * Plays through a tic tac toe game in which the player goes first.
	 * @param gameBoard The tic tac toe board
	 * @param user The human player
	 * @param computer The computer player
	 * @return true if there is a winner, false if the game ends in a draw
	 */
	public static boolean game1(char[][] gameBoard, Player user, Player computer) {
		startup();
		for(int o = 0; o < 1; o++) {
			for(int i = 0; i < 9; i++) {	
				if(winCheck(gameBoard).equals("user") || winCheck(gameBoard).equals("computer")) {
					return true;
				}
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter your placement (1-9): ");
				
				int comPos = 0;
				if(i % 2 == 0) {
					int pos = scan.nextInt();
					while(user.getMoveHistory().contains(pos) || computer.getMoveHistory().contains(pos)) {
						JOP.msg("Position taken! Please enter a new position.");
						pos = scan.nextInt();
					}
					
					System.out.println(pos);
					user.makeMove(gameBoard, pos, "user");
					TicTacToe.printBoard(gameBoard);
				}
				else {
					comPos = computer.generateComPosition(comPos);
					while(user.getMoveHistory().contains(comPos) || computer.getMoveHistory().contains(comPos)) {
						comPos = computer.generateComPosition(comPos);
					}
					
					System.out.println(comPos);
					computer.makeMove(gameBoard, comPos, "computer");
					TicTacToe.printBoard(gameBoard);
				}
			}
			if(winCheck(gameBoard).equals("user")) {
				JOP.msg("Congrats! You win.");
				return true;
			}
			else if(winCheck(gameBoard).equals("computer")) {
				JOP.msg("You lost.");
				return true;
			}
			draws++;
			JOP.msg("Draw.");
		}
		return false;
	}

	/**
	 * Plays through a tic tac toe game in which the computer goes first.
	 * @param gameBoard The tic tac toe board
	 * @param user The human player
	 * @param computer The computer player
	 * @return true if there is a winner, false if the game ends in a draw
	 */
	public static boolean game2(char[][] gameBoard, Player user, Player computer) {
		startup();
		for(int o = 0; o < 1; o++) {
			for(int i = 0; i < 9; i++) {	
				if(winCheck(gameBoard).equals("user") || winCheck(gameBoard).equals("computer")) {
					return true;
				}
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter your placement (1-9): ");
				
				int comPos = 0;
				if(i % 2 == 0) {
					comPos = computer.generateComPosition(comPos);
					while(user.getMoveHistory().contains(comPos) || computer.getMoveHistory().contains(comPos)) {
						comPos = computer.generateComPosition(comPos);
					}
					
					System.out.println(comPos);
					computer.makeMove(gameBoard, comPos, "computer");
					TicTacToe.printBoard(gameBoard);
				}
				else {
					int pos = scan.nextInt();
					while(user.getMoveHistory().contains(pos) || computer.getMoveHistory().contains(pos)) {
						JOP.msg("Position taken! Please enter a new position.");
						pos = scan.nextInt();
					}
					
					System.out.println(pos);
					user.makeMove(gameBoard, pos, "user");
					TicTacToe.printBoard(gameBoard);
				}
			}
			if(winCheck(gameBoard).equals("user")) {
				JOP.msg("Congrats! You win.");
				return true;
			}
			else if(winCheck(gameBoard).equals("computer")) {
				JOP.msg("You lost.");
				return true;
			}
			JOP.msg("Draw.");
		}
		return false;
	}

	/**
	 * Helper method to display instructions.
	 */
	public static void startup() {
		JOP.msg("You are now playing Tic Tac Toe as the X player.");
		JOP.msg("1-3 is the first row, 4-6 is the second row, and 7-9 is the last row.");
		JOP.msg("Refer to the console for further instructions.");
	}

	/**
	 * Checks for a win (three in any direction) on the gameboard for either player
	 * @param gameBoard The tic tac toe board
	 * @return The winner, if there is one; if not returns an empty string
	 */
	public static String winCheck(char[][] gameBoard) {
		String w = "";
		
		if(gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
			w = "user";
			userWins++;
		}
		else if(gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
			w = "user";
			userWins++;
		}
		else if(gameBoard[4][0] == 'X' && gameBoard[4][2] == 'X' && gameBoard[4][4] == 'X') {
			w = "user";
			userWins++;
		}
		else if(gameBoard[0][0] == 'X' && gameBoard[2][0] == 'X' && gameBoard[4][0] == 'X') {
			w = "user";
			userWins++;
		}
		else if(gameBoard[0][2] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][2] == 'X') {
			w = "user";
			userWins++;
		}
		else if(gameBoard[0][4] == 'X' && gameBoard[2][4] == 'X' && gameBoard[4][4] == 'X') {
			w = "user";
			userWins++;
		}
		else if(gameBoard[0][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][4] == 'X') {
			w = "user";
			userWins++;
		}
		else if(gameBoard[4][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[0][4] == 'X') {
			w = "user";
			userWins++;
		}
		else if(gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O') {
			w = "computer";
			comWins++;
		}
		else if(gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O') {
			w = "computer";
			comWins++;
		}
		else if(gameBoard[4][0] == 'O' && gameBoard[4][2] == 'O' && gameBoard[4][4] == 'O') {
			w = "computer";
			comWins++;
		}
		else if(gameBoard[0][0] == 'O' && gameBoard[2][0] == 'O' && gameBoard[4][0] == 'O') {
			w = "computer";
			comWins++;
		}
		else if(gameBoard[0][2] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][2] == 'O') {
			w = "computer";
			comWins++;
		}
		else if(gameBoard[0][4] == 'O' && gameBoard[2][4] == 'O' && gameBoard[4][4] == 'O') {
			w = "computer";
			comWins++;
		}
		else if(gameBoard[0][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][4] == 'O') {
			w = "computer";
			comWins++;
		}
		else if(gameBoard[4][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[0][4] == 'O') {
			w = "computer";
			comWins++;
		}
		
		return w;
	}

	/**
	 * Prints the amount of wins for each player as well as the number of draws, and
	 * shows the player who has more wins.
	 */
	public static void printWins() {
		System.out.println("User wins: " + userWins);
		System.out.println("Computer wins: " + comWins);
		System.out.println("Draws: " + draws);
		if(userWins > comWins) {
			JOP.msg("You have more wins, congrats.");
		}
		else if(userWins < comWins) {
			JOP.msg("The computer has more wins.");
		}
		else {
			JOP.msg("You drew with the computer.");
		}
	}
}
