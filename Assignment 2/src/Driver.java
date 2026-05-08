//ToDo: Supervisor wants programmer comments (use /* */ comment)
/*
 * This is the Driver class for Assignment 02 of CST8116
 */
//ToDo: Supervisor wants programmer comments (use /* */ comment)
/*
 * It controls the main flow of jeans, validate the measurement against expected 
 * tolerance using JeansChecker, and report the result
 */
public class Driver {

	public static void main(String[] args) {
		JeansChecker jeansChecker = new JeansChecker();
		Jeans jeans = new Jeans();
		String result = "";
		double waist = 0.0;
		double length = 0.0;
		int outOfTolerance = 0;
		String answer = "yes";
		
		// (other variables as needed)
		
		// TO DO:
		do {
		// Output "Enter jeans dimensions (expected: 25.5 for waist, 34.5 for length):"
		// Do not hard coded the expected dimension
		// You must retrieve the expected dimension from the Jeans class (and not the jeans object!)
			System.out.println("Enter jeans dimensions (expected: W:25.5 L:34.5)");
		// Using static methods from class User, prompt the user to
		// enter the waist and length as measured.
			waist = User.inputDouble("Enter measured waist (inch): ");
			length = User.inputDouble("Enter measured length (inch): ");
		// set the dimensions into an instance of Jeans
			jeans.setWaist(waist);
			jeans.setLength(length);
		// Use the toString method of class Jeans
		// to output the information for the Jeans. 
			result = jeans.toString();
			System.out.print(result);
		// Use the JeansChecker method to check if the
		// jeans is within specifications for waist and length
		// by passing that method the Jeans reference-value as an argument.
			boolean isWithinTolerance = jeansChecker.checkWithinTolerance(jeans);
		// Report to the user if the jeans is within tolerance or not.
		// (See Sample Program Run for report format)
		// Keep track of how many were not within tolerance for later reporting
			if (isWithinTolerance) {
				System.out.println("The jeans is within tolerance.");
			} else {
				System.out.println("The jeans is not within tolerance.");
				outOfTolerance++;
				}
		// Print out your name on screen
		System.out.println("Program designed by Jay Chao");
		// Using a loop ask if there is more data to enter (yes, no)
		// by using static methods from class User, and continue
		// only if the user enters some form of yes
		// e.g. "YES" "yEs" "yeS" would be acceptable (any capitalization)
		// if yes, processing should repeat in outputting the menu as above.
		answer = User.inputString("Have more jeans to check? (yes/no): ");
		} while (answer.equalsIgnoreCase("yes")) ;
		// If there is no more data to enter, let the user know how many times
		// the battery were out of tolerance.
		System.out.println("Total Jeans Out of Tolerance: " + outOfTolerance);
		// Note: You can use any decision structure or loop for this program,
		// however consider that we don't know in advance how many times
		// the loop will run.
		System.out.println("End of Program\n");
		
	}
}