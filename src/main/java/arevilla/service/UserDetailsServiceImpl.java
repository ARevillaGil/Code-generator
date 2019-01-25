package arevilla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import arevilla.model.AppUser;
import arevilla.web.error.UserNotFoundException;

/**
 * Implementation of the UserDetailsService.
 * @author Alberto Revilla
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {
	/**
	 * The user service
	 */
	@Autowired
    private IUserService userService; 
	/**
	 * Load the user to the application after the login.
	 */
	  @Override
	  public UserDetails loadUserByUsername(String userName) throws UserNotFoundException {

	    AppUser user = userService.getUser(userName);
	 
	    UserBuilder builder = null;
	    if (user != null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(userName);
	      builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
	      builder.roles("USER");
	    } else {
	      throw new UserNotFoundException("User not found.");
	    }

	    return builder.build();
	  }

}
