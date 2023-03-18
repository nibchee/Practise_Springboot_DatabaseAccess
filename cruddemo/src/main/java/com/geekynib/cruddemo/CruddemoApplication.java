package com.geekynib.cruddemo;

import com.geekynib.cruddemo.dao.StudentDAO;
import com.geekynib.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
		};
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
