package tictactoe;

/**
 * The main class for this program, contains the main method as well as methods to reset and
 * print the board.
 */
public class TicTacToe {

	/**
	 * The main method for this program. Creates the board and starts the game.
	 * @param args The command-line arguments used to start the program
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			boolean b = true;
			while(b) {
				char[][] gameBoard = {
						{' ','|',' ','|',' '},
						{'-','+','-','+','-'},
						{' ','|',' ','|',' '},
						{'-','+','-','+','-'},
						{' ','|',' ','|',' '}
						};
				
				Player user = new Player("user");
				Player computer = new Player("computer");
				
				
				Game.startGame(gameBoard, user, computer);
				
				String playAgain = JOP.in("Would you like to play again? (Y or N)");
				if(!replay(playAgain)) {
					b = false;
				}
				
			}
			Game.printWins();
		}
		catch(NullPointerException e) {
			Game.printWins();
		}
	}

	/**
	 * Prints the game board to the system.
	 * @param gameBoard The tic tac toe board that is to be printed
	 */
	public static void printBoard(char[][] gameBoard) {
		for(char[] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println("");
		}
	}

	/**
	 * Checks for if the player wants to play again. Any string other than N will restart the game.
	 * @param playAgain If this string is "N" the program will shut down, else the game will restart
	 * @return true if the user wishes to play again, false if not
	 */
	public static boolean replay(String playAgain) {
		if(playAgain.equalsIgnoreCase("N")) {
			return false;
		}
		return true;
	}

}
