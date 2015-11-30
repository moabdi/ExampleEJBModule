package job.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import job.IAccountLocal;
import job.IAccountRemote;
import job.entities.Account;

/**
 * EJB session is a component that has <li>A remote interface that allows to
 * report methods that can be accessed remotely.</li> <li>A Local interface that
 * allows to report methods that are available locally. Methods accessible
 * components deployed the same application server.</li>
 * 
 * @author Mostapha ABDI (abdimostapha.gmail)
 * @version 1.0
 */
@Stateless(name = "AccountEJB")
public class AccountEJBImpl implements IAccountLocal, IAccountRemote {

	/**
	 * Persistence Context
	 */
	@PersistenceContext(unitName = "BankEJB")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.IBankLocal#addAccount(job.entities.Account)
	 */
	@Override
	public Account addAccount(Account pAccount) {
		em.persist(pAccount);
		return pAccount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.IBankLocal#getAccount(java.lang.Long)
	 */
	@Override
	public Account getAccount(Long pCode) {
		Account account = em.find(Account.class, pCode);
		if (account == null)
			throw new RuntimeException("Compte not found");
		return account;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.IBankLocal#AccountList()
	 */
	@Override
	public List<Account> AccountList() {
		Query query = em.createQuery("select a from Account a ");
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.IBankLocal#deposit(java.lang.Long, double)
	 */
	@Override
	public void deposit(Long pCode, double pAmount) {
		Account account = getAccount(pCode);
		account.setBalance(account.getBalance() + pAmount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.IBankLocal#withdrawal(java.lang.Long, double)
	 */
	@Override
	public void withdrawal(Long pCode, double pAmount) {
		Account cp = getAccount(pCode);
		if (cp.getBalance() < pAmount)
			throw new RuntimeException("Insufficient balance");
		cp.setBalance(cp.getBalance() - pAmount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.IBankLocal#transfer(java.lang.Long, java.lang.Long, double)
	 */
	@Override
	public void transfer(Long pCodeFrom, Long pCodeTo, double pAmount) {
		// Manage Transaction
		EntityTransaction transaction = em.getTransaction();
		try {
			withdrawal(pCodeFrom, pAmount);
			deposit(pCodeTo, pAmount);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}

}
