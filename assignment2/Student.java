/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8284 313
 * Lab Professor: Fedor Ilitchev
 * Lab number: Assignment 2
 */

package assignment2;

/**
 * Represents a student with identifying information and a grade
 * This class implements {@code Comparable<Student>} so that student instances 
 * can be ordered by grade in descending order
 */
public class Student implements Comparable<Student> {
	private String name;
	private int id;
	private String email;
	private double grade;
		
	/**
	 * Constructs a new Student instance with the specified properties
	 * @param name the name of the student
	 * @param id the student id
	 * @param email the email address of the student
	 * @param grade the grade achieved by the student
	 * */
	public Student(String name, int id, String email, double grade) {
		this.name = name;
		this.id = id;
		this.email = email;
		this.grade = grade;
	}
	
	/**
	 * Returns a formatted string representation of this student,
	 * including name, id, email, grade
	 * @return a string in the format
	 */
	@Override
	public String toString() {
		return String.format("Student{name='%s', id=%d, email='%s', grade=%.1f}", name, id, email, grade);
	}
	
	/**
	 * Compares this student with another student for ordering by grade
	 * Returns a negative integer, zero, or a positive integer
	 * as this student's grade is greater than , equal to, 
	 * or less than the specified student's grade
	 * @param others the student to be compared
	 * @return a negative integer, zero, or a positive integer based on grade comparison in descending order
	 */
	@Override
    public int compareTo(Student others) {
         if (this.grade > others.grade) {
             return 1;
         } else if (this.grade < others.grade) {
             return -1;
         } else {
             return 0;
         }
    }
}
