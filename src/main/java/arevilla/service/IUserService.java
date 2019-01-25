package arevilla.service;

import arevilla.model.AppUser;
import arevilla.web.error.ExistingUserException;
/**
 * Interface to manage the application users.
 * @author Alberto Revilla
 *
 */
public interface IUserService {
	/**
	 * Register a new application user in the database.
	 * @param newUser the new user
	 * @return the saved user
	 * @throws ExistingUserException a user with the same user name has been saved in the database.
	 */
	AppUser registerNewUserAccount(AppUser newUser) throws ExistingUserException;

	/**
	 * Find a user by its user name and password.
	 * @param userName
	 * @param password
	 * @return the user found in the database
	 */
	AppUser getUser(String userName, String password);
	/**
	 * Find a user by its user name.
	 * @param userName
	 * @return the user found in the database
	 */
	AppUser getUser(String userName);

	/**
	 * Remove a user from the database.
	 * @param user
	 */
    void deleteUser(AppUser user);
}
