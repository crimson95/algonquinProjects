/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8284 313
 * Lab Professor: Fedor Ilitchev
 * Lab number: Assignment 2
 */

package assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages a collection of Student instances
 * Provides operations to add, remove, display, and sort students
 * by grade in descending order
 */
public class StudentManager implements Comparable<StudentManager>{
	private List<Student> students;
	
	/**
	 * Initializes an empty StudentManager 
	 */
	public StudentManager() {
		students = new ArrayList<>();
	}
	
	/**
	 * Adds the specified student to the manager
	 * @param student the student to add
	 */
	public void addStudent(Student student) {
		students.add(student);
	}
	
	/**
	 * Removes the specified student from the manager
	 * @param student the student to remove 
	 */
	public void removeStudent(Student student) {
		students.remove(student);
		}
	
	/**
	 * Displays all students currently in the manager to standard output 
	 */
	public void displayStudents() {
		for (Student student: students) {
			System.out.println(student);
		}
	}
	
	/**
	 * Sorts the student list in descending order by grade
	 */
	public void sortStudentByGrade() {
		Collections.sort(students);
	}
	
	@Override
    public int compareTo(StudentManager others) {
		
         if (this.students.size() > others.students.size()) {
             return 1;
         } else if (this.students.size() < others.students.size()) {
             return -1;
         } else {
             return 0;
         }
    }
}
