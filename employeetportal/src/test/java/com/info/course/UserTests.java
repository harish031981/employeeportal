package com.info.course;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.info.course.domain.User;
import com.info.course.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTests {


	private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Test
    public void addUser() {
    	User user = new User("testuser1", "testuser1", "USER1");

    	assertNull(user.getId());
    	userRepository.save(user);
    	assertNotNull(user.getId());
    }

    
    @Test
    public void deleteUser() {
    	User user = new User("testuser4", "testuser4", "USER4");

    	assertNull(user.getId());
    	userRepository.save(user);
    	assertNotNull(user.getId());
    	userRepository.delete(user);
    	Optional<User> findUser = userRepository.findById(user.getId());
    	assertFalse(findUser.isPresent());
    }
    
}
