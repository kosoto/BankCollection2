package service;

import domain.*;

public interface AccountService {
	public void createAccount(AccountBean account);
	public void addList(AccountBean account);
	public AccountBean[] list();
	public int deposit(int restMoney,String money);
	public int withdraw(int restMoney, String money);
	public String createAccountNum();
	public String createRandom(int start, int end);
	public String createDate();
	public AccountBean findById(AccountBean account);
	public AccountBean[] findByName(String name);
	public int countSameWord(String word);
	public AccountBean[] findMinusAccounts();
	public int countMinusAccounts();
	public String changePass(AccountBean account);
	public void rewriteAccount(AccountBean account);
	public String deleteAccount(AccountBean account);
}
