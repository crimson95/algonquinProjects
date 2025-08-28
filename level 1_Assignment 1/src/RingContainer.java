/*
 * Class Name: Introduction to Computer Programming
 * Student Name: Chieh-Yun Chao (Jay)
 * Lab Professor: Rama Thavasinadar
 * Due Date: 2025.02.09
 * Description: A brief description of calculation of the volume of
 * the Ring Container, and how many cups to fill out the container.
 */

public class RingContainer {
	
	//instance variables
	private double outerRadius;
	private double innerRadius;
	private double height;
	
	//default constructor
	public RingContainer() {
	}
	
	//parameterized constructor
	public RingContainer(double outerRadius, double innerRadius, double height) {
		this.outerRadius = outerRadius;   //initializing variables
		this.innerRadius = innerRadius;
		this.height = height;
	}
	
	//getter for OuterRadius
	public double getOuterRadius() {
		return outerRadius;
	}
	
	//setter for OuterRadius
	public void setOuterRadius(double outerRadius) {
		this.outerRadius = outerRadius;
	}
	
	//getter for InnerRadius
	public double getInnerRadius() {
		return innerRadius;
	}
	
	//setter for InnerRadius
	public void setInnerRadius(double innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	//getter for Height
	public double getHeight() {
		return height;
	}
	
	//setter for Height
	public void setHeight(double height) {
		this.height = height;
	}
	 
	//method to calculate the volume of the ring container
	public double calculateVolume(){  
		return (Math.pow(outerRadius, 2) - Math.pow(innerRadius, 2)) * height * Math.PI;
	}
	
	//method to calculate the number of cups to fill the container
	public double fillCups(double cupVolume) {   
		return calculateVolume() / cupVolume;
	}
}
