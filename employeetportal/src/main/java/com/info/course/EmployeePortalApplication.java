package com.info.course;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.info.course.domain.Course;
import com.info.course.domain.CourseRepository;
import com.info.course.domain.Student;
import com.info.course.domain.StudentRepository;
import com.info.course.domain.User;
import com.info.course.domain.UserRepository;

@SpringBootApplication
public class EmployeePortalApplication {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeePortalApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeePortalApplication.class, args);
	}
	
	/**
	 * Save users and students to H2 DB for testing
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(StudentRepository repository, CourseRepository crepository, UserRepository urepository) {
		return (args) -> {
			// save students
			Student student1 = new Student("John", "Johnson", "IT", "john.johnson@edureka.com"); 
			Student student2 = new Student("Steve", "Stevens", "IT", "steve.stevent@edureka.com"); 
			Student student3 = new Student("Mary", "Robinson", "IT", "mary.robinson@edureka.com"); 
			Student student4 = new Student("Kate", "Keystone", "Admin","kate.keystone@edureka.com"); 
			Student student5 = new Student("Diana", "Doll", "Business","diana.doll@edureka.com"); 
			Student student6 = new Student("Victor", "Dvoryaninov", "IT","victor.dvoryaninov@edureka.com"); 
			Student student7 = new Student("Dmitriy", "Korablev", "IT","dmitriy.korablev@edureka.com"); 
			Student student8 = new Student("Andrey", "Kim", "IT","Andrey.kim@edureka.com"); 

			
			/*repository.save(new Student("Steve", "Stevens", "IT", "steve.stevent@edureka.com"));
			repository.save(new Student("Mary", "Robinson", "IT", "mary@edureka.com"));
			repository.save(new Student("Kate", "Keystone", "Admin","kate@edureka.com"));
			repository.save(new Student("Diana", "Doll", "Business","diana@edureka.com"));
			
			repository.save(new Student("Victor", "Dvoryaninov", "IT","victor.dvoryaninov@edureka.com"));
			repository.save(new Student("Dmitriy", "Korablev", "IT","dmitriy.korablev@edureka.com"));
			repository.save(new Student("Andrey", "Kim", "IT","Andrey.kim@edureka.com"));
			*/
			
			Course course1 = new Course("Angular");
			Course course2 = new Course("Java");
			Course course3 = new Course(".Net");
			Course course4 = new Course("Agile");
			Course course5 = new Course("Office Equipment");
			crepository.save(new Course("Marketing"));
			crepository.save(new Course("HR"));
			
			crepository.save(course1);
			crepository.save(course2);
			crepository.save(course3);
			crepository.save(course4);
			crepository.save(course5);
			
			Set<Course> courses1 = new HashSet<Course>();
			courses1.add(course1);
			student1.setCourses(courses1); 
			repository.save(student1);

			Set<Course> courses2 = new HashSet<Course>();
			courses2.add(course2);
			student2.setCourses(courses2); 
			repository.save(student2);
			
			Set<Course> courses3 = new HashSet<Course>();
			courses3.add(course3);
			student3.setCourses(courses3); 
			repository.save(student3);

			Set<Course> courses4 = new HashSet<Course>();
			courses4.add(course5);
			student4.setCourses(courses4); 
			repository.save(student4);
			
			Set<Course> courses5 = new HashSet<Course>();
			courses5.add(course4);
			student5.setCourses(courses5); 
			repository.save(student5);

			Set<Course> courses6 = new HashSet<Course>();
			courses6.add(course1);
			student6.setCourses(courses6); 
			repository.save(student6);
			
			Set<Course> courses7 = new HashSet<Course>();
			courses7.add(course3);
			student7.setCourses(courses7); 
			repository.save(student7);
			
			Set<Course> courses8 = new HashSet<Course>();
			courses8.add(course2);
			student8.setCourses(courses8); 
			repository.save(student8);
			
			// Create users with BCrypt encoded password (user/user, admin/admin)
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
			urepository.save(user1);
			urepository.save(user2); 
		};
	}
}
