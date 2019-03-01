package com.info.course;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.info.course.domain.Course;
import com.info.course.domain.CourseRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeSkillTests {

    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }  
    
   	
	@Test
    public void addSkill() {
		
		Course course = new Course();
		course.setName("testcourse1");
		course.setStudents(new HashSet<>());
		courseRepository.save(course);
		List<Course> courses = courseRepository.findByName(course.getName());
		assertTrue(!courses.isEmpty());
    }
	
	@Test
    public void deleteCourse1() {
		
		Course course = new Course();
		course.setName("testcourse");
		course.setStudents(new HashSet<>());
		courseRepository.save(course);
		List<Course> courses = courseRepository.findByName(course.getName());
		assertTrue(!courses.isEmpty());
		
		courseRepository.delete(course);
		courses = courseRepository.findByName(course.getName());
		assertFalse(!courses.isEmpty());
    }
    
}
