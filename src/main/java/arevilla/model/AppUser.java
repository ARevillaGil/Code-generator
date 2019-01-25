package arevilla.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity for the application user data.
 * @author Alberto Revilla
 *
 */
@Entity
@Table(name = "user")
public class AppUser {
	/**
	 * The identificator for the user.
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_user")
	private long userId;
	/**
	 * The user name. It is going to be unique because it can be used just for one user 
	 * and it is going to be used as his login name. 
	 */
	@Column(name="user_name", unique = true)
	private String userName;
	/**
	 * The user real name.
	 */
	@Column(name="name")
	private String name;
	/**
	 * The user real surname.
	 */
	@Column(name="surname")
	private String surname;
	/**
	 * The password of the user account. It is going to be used to login the application.
	 */
	@Column(name="password")
	private String password;
	
	/**
	 * The set with all the codes that the user has.
	 */
	@OneToMany(mappedBy="code")
    private Set<Code> codes;
	/**
	 * Constructor without fields.
	 */
	public AppUser() {
		
	}
	/**
	 * Constructor with fields.
	 * @param userName the user unique name
	 * @param name the user real name
	 * @param surname the user real surname
	 * @param password the user password
	 */
	public AppUser(String userName, String name, String surname, String password) {
		super();
		this.userName = userName;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}

	/**
	 * Constructor with the unique user name.
	 * @param userName the user unique name
	 */
	public AppUser(String userName) {
		super();
		this.userName = userName;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Code> getCodes() {
		return codes;
	}
	public void setCodes(Set<Code> codes) {
		this.codes = codes;
	}
}
