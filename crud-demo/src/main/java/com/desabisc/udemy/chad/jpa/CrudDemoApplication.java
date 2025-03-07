package com.desabisc.udemy.chad.jpa;

import com.desabisc.udemy.chad.jpa.dao.StudentDAO;
import com.desabisc.udemy.chad.jpa.entity.Student;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	/**
	 * Executed after the Spring Beans have been loaded.
	 *
	 * @param
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id : " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		
		// change first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("John");
		
		// update the student
		studentDAO.update(myStudent);
		
		// display the updated student
		System.out.println("Updated student:  " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findByLastName("Doe");
		// display list of students
		students.forEach(System.out::println);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		studentDAO.findAll().forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create a student object
		System.out.println("Creating new student object...");
		Student tmpStudent = new Student("Daffy", "Duck", "daffy@domain.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tmpStudent);

		// display id of the student
		int theId = tmpStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve the student based on the id: primary key
		System.out.println("Retrieve the student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// Create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("John", "Doe", "jhon@domain.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@domain.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@domain.com");

		// save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// Change auto increment: ALTER TABLE student_tracker.student AUTO_INCREMENT=300
		// To restart de id column: TRUNCATE student_tracker.student
	}

	private void createStudent(StudentDAO studentDAO) {
		// Create the student
		System.out.println("Creating Student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@domain.com");

		// Save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
