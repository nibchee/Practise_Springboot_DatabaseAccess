package com.geekynib.cruddemo;

import com.geekynib.cruddemo.dao.StudentDAO;
import com.geekynib.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//Creating Bean this is from Spring Framework executed after beans are loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		//Java Lamda Expression
		return  runner->{
		//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

		//readStudent(studentDAO);
	//	queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);
		//updateStudent(studentDAO);
		//	deleteStudent(studentDAO);

		//	deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleteing all Students");
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
	    int studentId=3;
		System.out.println("Deleting the student id:"+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
	        //retrieve student based on id:primary id
   int studentId=1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent=studentDAO.findById(studentId);
		//change  first name to "Scooby"
		System.out.println("Updating Student...");
		myStudent.setFirstName("Scooby");


		//Update the Student
		studentDAO.update(myStudent);
		//diaply the update student
		System.out.println("Updated Student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//get a list of students
       List<Student> theStudents=studentDAO.findByLastName("Bansal");
		//display list of students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of Students
		List<Student> theStudents=studentDAO.findAll();
		//display list of Students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating a new student object...");
		Student tempStudent=new Student("Cheenu","bansal","cheenub28@gmail.com");

		//save a student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of saved student
		int theId=tempStudent.getId();
		System.out.println("Saved student, Generated id"+theId);

		//retrieve student based on id: primary key
		System.out.println("Retrieving student with id "+theId);
		Student myStudent=studentDAO.findById(theId);

		//display student
		System.out.println("Found the Student " +myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
	  //create Multiple Students
		System.out.println("Creating 3 Student object...");
		Student tempStudent1=new Student("Nirbhay","Bansal","nirbhaybansal28@gmail.com");
		Student tempStudent2=new Student("Aayush","Bansal","aayush28@gmail.com");
		Student tempStudent3=new Student("Aayushi","Bansal","aayushibansal28@gmail.com");
		//save the student object
		System.out.println("Saviing the Studets..");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create Student Object
		System.out.println("Creating new Student object...");
		Student tempStudent=new Student("Nirbhay","Bansal","nirbhaybansal28@gmail.com");
		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of saved student
		System.out.println("Saved student .Generatd id:"+tempStudent.getId());
	}

}
