package tictactoe;

import javax.swing.JOptionPane;

/**
 * This class serves as an easier way to use JOptionPane methods
 */
public class JOP {
	/**
	 * Displays a message on JOptionPane.
	 * @param msg The message to be displayed
	 */
	public static void msg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	/**
	 * Displays a dialog box for user input.
	 * @param msg The prompt to be displayed for input
	 * @return The user input
	 */
	public static String in(String msg) {	
		return JOptionPane.showInputDialog(msg);
	}
}
