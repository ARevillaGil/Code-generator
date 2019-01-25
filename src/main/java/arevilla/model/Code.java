package arevilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity for the codes.
 * @author Alberto Revilla
 *
 */
@Entity
@Table(name="code")
public class Code {
	/**
	 * The id for the code.
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_code")
	private long codeId;
	
	/**
	 * The code. It must be unique.
	 */
	@Column(name="code", unique = true)
	private String code;
	/**
	 * The field used is true if the code has been used.
	 */
	@Column(name="used")
	private boolean used;
	
	/**
	 * The owner of the code.
	 */
	@ManyToOne
	@JoinColumn(name="id_user", nullable=false)
	private AppUser user;

	public long getCodeId() {
		return codeId;
	}

	public void setCodeId(long codeId) {
		this.codeId = codeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public AppUser getAppUser() {
		return user;
	}

	public void setAppUser(AppUser user) {
		this.user = user;
	}

}
