package arevilla.service;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import arevilla.model.AppUser;
import arevilla.web.error.ExistingUserException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional 
public class UserTests2 {
 
	@Autowired
    private UserService userService;
	
	  @Test
	  public void saveNewUser() { 
		  AppUser u = new AppUser("testUser", "name", "surname", "password"); 
		  AppUser user = userService.registerNewUserAccount(u); 
		  assertNotNull(user);
		  userService.deleteUser(user);
	  }
	 
	  @Test(expected = ExistingUserException.class)
	  public void saveExistingUser() throws ExistingUserException {
		  userService.registerNewUserAccount(new AppUser("testUser", "testUser", "testUser", "testUser")); 
		  userService.registerNewUserAccount(new AppUser("testUser", "testUser", "testUser", "testUser")); 
	  }
	 
}
