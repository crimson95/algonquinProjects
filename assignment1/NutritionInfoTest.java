package assignment1;

/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8284 313
 * Lab Professor: Sandra Iroakazi
 * Lab number: Assignment 1
 */

import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * Unit tests for the NutritionInfo class.
 * Verifies the behavior for NutritionInfo#computeFatPercentage(),
 * NutritionInfo#computeIsSourceCalcium(), NutritionInfo#computeIsHighFibre()
 * @author Jay Chao
 */
public class NutritionInfoTest {

	private static final double EPSILON = 1E-12;
	
	/** Default Constructor */
	public NutritionInfoTest() {}
	
	/** test method for computeFatPercentage() by using assertEquals */
	@Test
	public void testComputeFatPercentage_equals() {
		NutritionInfo info = new NutritionInfo(100, "grams", 200.0, 10.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		double expected = 45.0;
		assertEquals(expected, info.computeFatPercentage(), EPSILON);
	}
	
	/** test method for computeFatPercentage() by using assertTrue */
	@Test
	public void testComputeFatPercentage_true() {
		NutritionInfo info = new NutritionInfo(100, "grams", 200.0, 10.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		double change = info.computeFatPercentage();
		double expected = 45.0;
		assertTrue(Math.abs(change-expected) < EPSILON);
	}

	/** test method for computeIsSourceCalcium() by using assertTrue */
	@Test
	public void testComputeIsSourceCalcium_true() {
		NutritionInfo info = new NutritionInfo(100, "grams", 200.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 100.0, 0.0, 0.0);
		assertTrue(info.computeIsSourceCalcium());
	}
	
	/** test method for computeIsSourceCalcium() by using assertFalse */
	@Test
	public void testComputeIsSourceCalcium_false() {
		NutritionInfo info = new NutritionInfo(100, "grams", 200.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 80.0, 0.0, 0.0);
		assertFalse(info.computeIsSourceCalcium());
	}

	/** test method for computeIsHighFibre by using assertTrue */
	@Test
	public void testComputeIsHighFibre_true() {
		NutritionInfo info = new NutritionInfo(100, "grams", 200.0, 10.0, 0.0, 0.0, 0.0, 6.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		assertTrue(info.computeIsHighFibre());
	}
	
	/** test method for computeIsHighFibre by using assertFalse */
	@Test
	public void testComputeIsHighFibre_false() {
		NutritionInfo info = new NutritionInfo(100, "grams", 200.0, 10.0, 0.0, 0.0, 0.0, 4.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		assertFalse(info.computeIsHighFibre());
	}

}
