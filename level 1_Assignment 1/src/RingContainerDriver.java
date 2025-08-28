/*
 * Class Name: Introduction to Computer Programming
 * Student Name: Chieh-Yun Chao (Jay)
 * Lab Professor: Rama Thavasinadar
 * Due Date: 2025.02.09
 * Description: A brief description of calculation of the volume of
 * the Ring Container, and how many cups to fill out the container.
 * This driver demonstrates the use of the RingContainer class.
 */

import java.util.Scanner;

public class RingContainerDriver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// declare variables
		double innerRadius;
		double outerRadius;
		double height;
		double cupVolume;
		
		//input of the inner radius
		System.out.print("Please enter the inner radius of the Ring Container in centimeters: ");
		innerRadius = input.nextDouble();
		
		//input of the outer radius
		System.out.print("Please enter the outer radius of the Ring Container in centimeters: ");
		outerRadius = input.nextDouble();
		
		//input of the height
		System.out.print("please enter the height of the Ring Container in centimeters: ");
		height = input.nextDouble();
		
		//input of the volume of a single cup
		System.out.print("Please enter volume of a single cup in millieters: ");
		cupVolume = input.nextDouble();
		
		//create RingContainer object using parameterized constructor
		RingContainer container = new RingContainer(); 
		
		//Use the set method to retrieve values from the RingContainer class
		container.setInnerRadius(innerRadius);
		container.setOuterRadius(outerRadius);
		container.setHeight(height);
		
		//output the container volume and the number of cups
		System.out.printf("Your container has a volume of %.2f ml cubed and can fill %.2f cups.\n", container.calculateVolume(), container.fillCups(cupVolume));
		System.out.println("For the sake of simplicity, wall width is not considered in these calculations.");
		System.out.println("Program by Jay Chao");
		
		input.close();
	}
}
