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
			Student student1 = new Student("John", "Johnson", "IT", "john@john.com"); 
			repository.save(new Student("Steve", "Stevens", "IT", "steve.stevent@st.com"));
			repository.save(new Student("Mary", "Robinson", "IT", "mary@robinson.com"));
			repository.save(new Student("Kate", "Keystone", "Nursery","kate@kate.com"));
			repository.save(new Student("Diana", "Doll", "Business","diana@doll.com"));
			
			Course course1 = new Course("Programming Java");
			Course course2 = new Course("Spring Boot basics");
			crepository.save(new Course("Marketing 1"));
			crepository.save(new Course("Marketing 2"));
			
			crepository.save(course1);
			crepository.save(course2);
			
			Set<Course> courses = new HashSet<Course>();
			courses.add(course1);
			courses.add(course2);
			
			student1.setCourses(courses); 
			repository.save(student1);

			// Create users with BCrypt encoded password (user/user, admin/admin)
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
			urepository.save(user1);
			urepository.save(user2); 
		};
	}
}