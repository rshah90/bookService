package com.maven.bookService;

import java.util.List;

import com.maven.bookService.model.User;
import com.maven.bookService.repository.UserRepository;
import com.maven.bookService.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUser(){
        User user = new User();
        user.setId(5L);
        user.setFirstName("Rush");
        user.setLastName("Shah");
        user.setEmailAddress("Rush@yahoo.com");
        when(userRepository.getOne(5L)).thenReturn(user);

        User result = userService.getObjectById(5L);
        assertEquals(5L, result.getId().longValue());
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setId(5L);
        user.setFirstName("Rush");
        user.setLastName("Shah");
        user.setEmailAddress("Rush@yahoo.com");
        when(userRepository.save(user)).thenReturn(user);
        User result = userService.saveObject(user);
        assertEquals(5L, result.getId().longValue());
        assertEquals("Rush", result.getFirstName());
    }
}
