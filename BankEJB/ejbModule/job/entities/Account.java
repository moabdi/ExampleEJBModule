package job.entities;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Account Represents the data
 * manipulated by the application
 * 
 * @author Mostapha ABDI (abdimostapha.gmail)
 * @version 1.0
 */
@Entity
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * account identity, primary key, auto increment
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;

	/**
	 * banalce
	 */
	private double balance;
	
	/**
	 * Creation date
	 */
	private Date creationDate;
	

	/**
	 * Constructor without argument
	 */
	public Account() {

	}

	/**
	 * Constructor with arguments
	 */
	public Account(final double balance, final Date creationDate) {
		this.balance = balance;
		this.creationDate = creationDate;
	}

	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
