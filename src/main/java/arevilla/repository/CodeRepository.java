package arevilla.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import arevilla.model.AppUser;
import arevilla.model.Code;

/**
 * Interface for the code repository.
 * @author Alberto Revilla
 *
 */
@Repository
@Transactional
public interface CodeRepository extends CrudRepository<Code, Long>{

	/**
	 * Find the given code in the database.
	 * @param code the String to find in the code field list
	 * @return String with the code found
	 */
	String findByCode(String code);
	/**
	 * Find all the codes that the user has.
	 * @param user the owner of the codes
	 * @return a set with all the user codes
	 */
	Set<Code> findByUser(AppUser user);
}
