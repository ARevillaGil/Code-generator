package arevilla.service;

import java.util.Set;

import arevilla.model.AppUser;
import arevilla.model.Code;
/**
 * Interface to manage the codes.
 * @author Alberto Revilla
 *
 */
public interface ICodeService {

	/**
	 * Save a code in the database.
	 * @param code the code to save
	 * @return the code saved
	 */
	Code saveCode(Code code);
	/**
	 * Find the code in the database.
	 * @param code the code to save
	 * @return true if the code is found or false it is not
	 */
	boolean findCode(String code);
	/**
	 * Find all the codes for a user.
	 * @param user the user to find
	 * @return a set with all the user codes
	 */
	Set<Code> findByUser(AppUser user);
}
