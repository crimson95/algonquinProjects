/* Student Name: Jay Chao
 * Lab Professor: Professor Dr. Rama Thavasinadar
 * Due Date: 2025.03.30
 * Description: 25W_CST8116 Assignment 02
 */ 
 
/*
 *  This class models jeans with fields for waist and length (in inch)
 */
public class Jeans {
	// Declared expected dimensions of the jeans (in inch)
	public static final double EXPECTED_WAIST = 25.5; 
	public static final double EXPECTED_LENGTH = 34.5;

	// Declared measured dimensions of the jeans (in inch)
	private double waist;
	private double length;
	
	/*
	 * No-argument constructor, sets dimensions to the expected values
	 */
	public Jeans() {
		this(EXPECTED_WAIST, EXPECTED_LENGTH); 
	}
	
	/*
	 * Overloaded constructor, sets dimensions as specified
	 */
	public Jeans(double waist, double length) {
		this.waist = waist;
		this.length = length;
	}

	/*
	 * Accessor for waist (in inch)
	 */
	public double getWaist() {
		return waist;
	}

	/*
	 * Mutator for waist (in inch)
	 */
	public void setWaist(double waist) {
		this.waist = waist;
	}

	/*
	 * Accessor for length (in inch)
	 */
	public double getLength() {
		return length;
	}

	/*
	 * Mutator for length (in inch)
	 */
	public void setLength(double length) {
		this.length = length;
	}
	
	/*
	 * Returns a String that represents the data held within this object

	 */
	public String toString() {
		
		String formatString = ""; // initialized so that it compiles
		String result= ""; // initialized so that it compiles
		
		//TO DO Formulate and return a string that represents the data held within this object
		// Example of one such string: "Jeans: waist 25.10 length 34.5" 
		formatString = "%s %.2f %s %.2f%n"; 
		result = String.format(formatString, "Jeans: waist ", waist, ", length ", length);
		return result;
	}
}
