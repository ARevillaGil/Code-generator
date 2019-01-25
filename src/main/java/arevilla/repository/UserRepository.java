package arevilla.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import arevilla.model.AppUser;

/**
 * Interface for the user repository.
 * @author Alberto Revilla
 *
 */
@Repository
@Transactional
public interface UserRepository extends CrudRepository<AppUser, Long>{

	/**
	 * Find the user in the database by his user name.
	 * @param userName the user´s user name
	 * @return the user with his user name
	 */
	AppUser findByUserName(String userName);
	/**
	 * Find the user in the database by his user name and password.
	 * @param userName the user´s user name
	 * @param password the user´s password
	 * @return the user with his user name and password
	 */
	AppUser findByUserNameAndPassword(String userName, String password);
}
