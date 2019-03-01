package com.info.course;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.info.course.domain.Student;
import com.info.course.domain.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeTests {

	private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }    
    
        
	@Test
    public void addEmployee() {
		Student student = new Student("Test1", "Student", "IT", "test1@test.com");
		
		studentRepository.save(student);
		Optional<Student> findStudent = studentRepository.findById(student.getId());
		assertTrue(findStudent.isPresent());
    }
	
	
	@Test
    public void deleteEmployee() {
		Student student = new Student("Test2", "Student", "IT", "test2@test.com");
		
		studentRepository.save(student);
		Optional<Student> findStudent = studentRepository.findById(student.getId());
		assertTrue(findStudent.isPresent());
		
		studentRepository.delete(student);
		findStudent = studentRepository.findById(student.getId());
		assertFalse(findStudent.isPresent());
    }
	
	    
}
