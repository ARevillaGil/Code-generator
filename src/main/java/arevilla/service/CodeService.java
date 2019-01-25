package arevilla.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arevilla.model.AppUser;
import arevilla.model.Code;
import arevilla.repository.CodeRepository;
/**
 * Implementation of the ICodeService to manage the codes.
 * @author Alberto Revilla
 *
 */
@Service
@Transactional
public class CodeService implements ICodeService{
	/**
	 * The code repository.
	 */
	@Autowired
	private CodeRepository codeRepository;
	/**
	 * Save a code in the database.
	 * @param code the code to save
	 * @return the code saved
	 */
	@Override
	public Code saveCode(Code code) {
		return codeRepository.save(code);
		
	}
	/**
	 * Find the code in the database.
	 * @param code the code to find
	 * @return true if the code is found or false it is not
	 */
	@Override
	public boolean findCode(String code) {
		return codeRepository.findByCode(code) != null;
	}
	/**
	 * Find all the codes for a user.
	 * @param user the user to find
	 * @return a set with all the user codes
	 */
	@Override
	public Set<Code> findByUser(AppUser user) {
		return codeRepository.findByUser(user);
	}

}
