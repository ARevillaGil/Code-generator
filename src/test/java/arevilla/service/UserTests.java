package arevilla.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import arevilla.model.AppUser;
import arevilla.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
 
	@InjectMocks
    private UserService userService;
 
    @MockBean
    private UserRepository userRepository;
    
    @Before
    public void setUp() {
    	MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void whenValidName_thenUserShouldBeFound() {
    	AppUser u = new AppUser();
        u.setUserName("user");
        when(userRepository.findByUserName("user")).thenReturn(u);

        AppUser user = userService.getUser("user");

        verify(userRepository).findByUserName("user");

        assertEquals("user", user.getUserName());
     }
	 
}
