/* Student Name: Jay Chao
 * Lab Professor: Professor Dr. Rama Thavasinadar
 * Due Date: 2025.03.30
 * Description: 25W_CST8116 Assignment 02 Starter Code
 *		Update of original concept by Professor Stanley Pieda and David Haley
 *		This version of User provides static methods in lieu
 *      of instantiating an object of type User.
 */

/* This class verifies that data entered is numeric where needed, trapping
 * the user inside an infinite loop until they enter the requested data.
 * Example use from a Driver to obtain an double value from the console:
 *
 * double realNumber1 = User.inputDouble("Enter a real number: ");
 */

import java.util.Scanner;

/*
 * This class provides utility for getting user input from the console using
 * an instance of Scanner set to new Scanner(System.in)
 */
public class User {
	
	private static Scanner keyboard = new Scanner(System.in);
	
	/*
	 * This is a utility class with only static members, prevents
	 * instantiation. This private constructor should be in your
	 * detailed UML Diagram
	 */
	private User() { }
	
	/*
	 * This method prompts the user using the argument sent through message.
	 * It reads in a double value when there is one.
	 * If the user does not provide input that can be converted into a double
	 * an error message is printed requesting a correct input and a loop
	 * is used to trap the user until they get this right.
     */
	public static double inputDouble(String message) {
		boolean isInputBad = true;
		boolean hasNextDouble;
		System.out.printf("%s", message);
		double value = 0.0;
		
		// TO DO 
		// Write while loop that will be executed repeatedly until user enters a valid (double) data.
		// Use isInputBad as the condition for the while loop. Within the while loop,
			// - use keyboard.hasNextDouble() to check if the data entered is valid
			// - if the user has indeed entered valid (double) data then use keyboard.nextDouble() to read the value
		    // - otherwise print the error message
		    // - either way, use keyboard.nextLine() to clear the input stream at the end of the loop
		do {
			if(keyboard.hasNextDouble()) {
				value = keyboard.nextDouble();
				isInputBad = false;
			} else {
				System.out.print("Invalid input. Please enter a number: ");
			}
			keyboard.nextLine();
		} while(isInputBad);
		return value;	
	}
	
	/*
	 * This method prompts the user using the message supplied through the argument and 
	 * returns a string read from the console. 
	 * It reads until it encounter a line terminator character
	 */
	public static String inputString(String message) {
		System.out.printf("%s", message);
		return keyboard.nextLine();
	}

}