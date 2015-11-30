package job;

import java.util.List;

import javax.ejb.Remote;

import job.entities.Account;

/**
 * A remote interface allows to report methods that can be accessed remotely.
 * 
 * @author Mostapha ABDI (abdimostapha.gmail)
 * @version 1.0
 */
@Remote
public interface IAccountRemote {

	/**
	 * Add new Account to database
	 * 
	 * @param pAccount
	 *            : Account to create
	 * @return Account : Account created
	 */
	public Account addAccount(Account pAccount);

	/**
	 * Get an Account by ID
	 * 
	 * @param code
	 *            : Account identify
	 * @return Account
	 */
	public Account getAccount(Long pCode);

	/**
	 * Get account list found in database
	 * 
	 * @return List<Account> : List of Account
	 */
	public List<Account> AccountList();

	/**
	 * Deposits into Account
	 * 
	 * @param pCode
	 *            : Account identify
	 * @param pAmount
	 *            : Amount to deposit
	 */
	public void deposit(Long pCode, double pAmount);

	/**
	 * withdrawal an amount from account
	 * 
	 * @param pCode
	 *            : Account identify
	 * @param pAmount
	 *            : Amount to deposit
	 */
	public void withdrawal(Long pCode, double pAmount);

	/**
	 * Transfer amount from Account to another
	 * 
	 * @param pCodeFrom
	 *            : Account from identify
	 * @param pCodeTo
	 *            : Account to identify
	 * @param pAmount
	 *            : Amount to transfer
	 */
	public void transfer(Long pCodeFrom, Long pCodeTo, double pAmount);

}
