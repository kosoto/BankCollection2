package service;

import domain.*;

public interface AccountService {
	public void createAccount(AccountBean account);
	public void createMinusAccount(MinusAccountBean minusAccount);
	public void addList(AccountBean account);
	public AccountBean[] list();
	public int deposit(int restMoney,String money);
	public int withdraw(int restMoney, String money);
	public String createAccountNum();
	public String createRandom(int start, int end);
	public String createDate();
	//public String toString(AccountBean account);
	public AccountBean findById(AccountBean account);
	public AccountBean[] findByName(String name);
	public int countSameWord(String word);
	String showResult(AccountBean[] list);
	public AccountBean[] findMinusAccounts();
	public int countMinusAccounts();
	
	
}
