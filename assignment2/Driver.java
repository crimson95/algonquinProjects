/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8284 313
 * Lab Professor: Fedor Ilitchev
 * Lab number: Assignment 2
 */

package assignment2;

/**
 * Entry point for demonstrating Polymorphism by creating product instances
 * and invoking methods defined in Product and its subclasses.
 * Outputs product details and purchase messages to the console.
 * 
 * @author Jay Chao
 */
public class Driver {
	
	/**
	 * Default constructor
	 */
	public Driver() {}
	
	/**
     * Main method to demonstrate the functionality of PhysicalProduct and DigitalProduct classes.
     * @param args command-line arguments (not used)
     */
	public static void main(String[] args) {
		Student[] studentList = {
				new Student("Amy", 04, "amy@ac.com", 3.2),
				new Student("Bob", 02, "bob@ac.com", 2.5),
				new Student("Cal", 03, "Cal@ac.com", 3.8),
				new Student("Dean", 01, "dean@ac.com", 4.0),
		};
		StudentManager manager = new StudentManager();
		
		for (Student student: studentList) {
			manager.addStudent(student);
		}
		
		System.out.println("ArrayList before sorting:");
		manager.displayStudents();
		System.out.println();
		
		manager.sortStudentByGrade();
		System.out.println("ArrayList after sorting:");
		manager.displayStudents();
		System.out.println();
		
		manager.removeStudent(studentList[1]);
		System.out.println("ArrayList after removing student Bob:");
		manager.displayStudents();
	}
}
