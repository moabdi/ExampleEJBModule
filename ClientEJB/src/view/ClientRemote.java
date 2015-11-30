package view;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;

import job.IAccountRemote;
import job.entities.Account;

/**
 * Client Remote for test call ejb module
 * 
 * @author Mostapha ABDI (abdimostapha.gmail)
 * @version 1.0
 */
public class ClientRemote {

	/**
	 * Main
	 * @param args : arguments
	 */
	public static void main(String[] args) {

		try 
		{
			Context ctx = new InitialContext();
			String appName = "";
			String moduleName = "BankEJB";
			String beanName = "AccountEJB";
			String remoteInterface = IAccountRemote.class.getName();
			String name = "ejb:" + appName + "/" + moduleName + "/" + beanName
					+ "!" + remoteInterface;

			IAccountRemote proxy = (IAccountRemote) ctx.lookup(name);

			proxy.addAccount(new Account(125458, new Date()));
			proxy.addAccount(new Account(548754, new Date()));
			proxy.addAccount(new Account(89542214, new Date()));
		} 
		catch (Exception lExep) 
		{
			lExep.printStackTrace();
		}

	}
}
