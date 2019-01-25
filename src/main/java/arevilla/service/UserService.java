package arevilla.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arevilla.model.AppUser;
import arevilla.repository.UserRepository;
import arevilla.web.error.ExistingUserException;
/**
 * Implements the IUserService interface.
 * @author Alberto Revilla
 *
 */
@Service
@Transactional
public class UserService implements IUserService{

	/**
	 * The user repository.
	 */
	@Autowired
    private UserRepository userRepository;
	/**
	 * Register a new application user in the database.
	 * @param newUser the new user
	 * @return the saved user
	 * @throws ExistingUserException a user with the same user name has been saved in the database.
	 */
	@Override
	public AppUser registerNewUserAccount(AppUser newUser) throws ExistingUserException {
		if (userExists(newUser.getUserName())) {
            throw new ExistingUserException("Your user name is already in use. Please try another one: " + newUser.getUserName());
        }
        final AppUser user = new AppUser();
        user.setUserName(newUser.getUserName());
        user.setName(newUser.getName());
        user.setSurname(newUser.getSurname());
        user.setPassword(newUser.getPassword());
        return userRepository.save(user);
	}
	/**
	 * Remove a user from the database.
	 * @param user
	 */
	@Override
	public void deleteUser(AppUser user) {
		userRepository.delete(user);
	}
	/**
	 * Check if the user is in the database.
	 * @param userName the user name to search in the database
	 * @return true if the user exists or false if not
	 */
	private boolean userExists(final String userName) {
        return userRepository.findByUserName(userName) != null;
    }
	/**
	 * Find a user by its user name and password.
	 * @param userName
	 * @param password
	 * @return the user found in the database
	 */
	@Override
	public AppUser getUser(String userName, String password) {
		return null;
	}
	/**
	 * Find a user by its user name.
	 * @param userName
	 * @return the user found in the database
	 */
	@Override
	public AppUser getUser(String userName) {
		return userRepository.findByUserName(userName);
	}

}
