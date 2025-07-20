//ToDo: Supervisor wants programmer comments (use /* */ comment)
/*
 * This class is responsible for checking whether the size of the Jeans
 * is within the allowable tolerance range.
 */
//ToDo: Supervisor wants programmer comments (use /* */ comment)
/*
 * It contains the logic to validate if the inputed waist and length
 * measurements are within the acceptable tolerance range using absolute value
 * comparison.
 */

public class JeansChecker {

	// ToDo: create private final values for the following constants 
	 private static final double WAIST_TOLERANCE = 0.3;
	 private static final double LENGTH_TOLERANCE = 0.5;
	// WAIST_TOLERANCE as the acceptable waist tolerance (in mm)
	// LENGTH_TOLERANCE as the acceptable length tolerance (in mm)
	final double EPSILON = 1E-14;

	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*
	 * This method checks whether the given Jeans object's waist and length
	 * are within acceptable tolerance compared to the declared expected values.
	 */
	public boolean checkWithinTolerance(Jeans jeans) {
		
		//TO DO:
		// create local variables as required
		double waist = jeans.getWaist();
		double length = jeans.getLength();
		
		double expectedWaist = Jeans.EXPECTED_WAIST;
		double expectedLength = Jeans.EXPECTED_LENGTH;
		
		boolean isWaistCloseEnough = Math.abs(waist - expectedWaist) <= (WAIST_TOLERANCE + EPSILON);
		boolean isLengthCloseEnough = Math.abs(length - expectedLength) <= (LENGTH_TOLERANCE + EPSILON);
		
		/* Determine tolerances:
		 * make sure that the dimensions do not differ more than the acceptable
		 * tolerance using the constants from this class and from the Jeans
		 * class (do not hard code values).
		 */
		if (isWaistCloseEnough && isLengthCloseEnough) {
			return true;
		} else {
			return false;
		}
		
		// return a boolean that indicates if the jeans meets the specifications
		
		//return false; // placeholder so the code will compile
				
	}
}
