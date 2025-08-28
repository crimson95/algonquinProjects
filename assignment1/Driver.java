package assignment1;

/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8284 313
 * Lab Professor: Sandra Iroakazi
 * Lab number: Assignment 1
 */

/**
 * This is the driver for this program. This means that it just runs the application with a method main
 * @author Jay Chao
 */
public class Driver {
	
	/** Default Constructor */
	public Driver() {}
	
	/**
	 * Entry point for the application. 
	 * Creates a {@link NutritionInfo} object,
	 * then invokes {@link NutritionInfo#printHealthReport()} and {@link NutritionInfo#printLabel()}
	 * to display the nutrition data defined in the NutritionInfo class.
	 * @param args Command line arguments are not used by this program.
	 */
	public static void main(String[] args) {
		NutritionInfo info = new NutritionInfo(32, "grams", 160.0, 8.0, 5.0, 0.2, 21.0, 1.0, 10.0, 2.0, 0.0, 85.0, 40.0, 20.0, 0.2, 0.0);
		System.out.println(info.printHealthReport());
		System.out.println(info.printLabel(0.5));
	}
}
