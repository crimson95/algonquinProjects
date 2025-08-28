/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8284 313
 * Lab Professor: Fedor Ilitchev
 * Lab number: Assignment 3
 */

package assignment3;

import javax.swing.SwingUtilities;

/**
 * example main() which launches a Swing application
 * uses SwingUtilities.invokeLater()
 * @author Jay
 *
 */
public class JayTest {
	
	/**
	 * Default constructor
	 */
	public JayTest() {}
	
	/**
	 * Entry point for the application.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SecureRandom());
	}
}
